package zver.nohonor.entity.custom.gnome;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import zver.nohonor.entity.ModEntityTypes;

public class GnomeEntity extends PathfinderMob {

    public GnomeEntity(Level world) {
        this(ModEntityTypes.GNOME, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    public GnomeEntity(EntityType<? extends GnomeEntity> entityType, Level world) {
        super(entityType, world);
    }

    public static AttributeSupplier.Builder createCubeAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.4);
    }

    private static final EntityDataAccessor<Boolean> DANCING = SynchedEntityData.defineId(GnomeEntity.class, EntityDataSerializers.BOOLEAN);
    private int dancingTimeLeft;

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DANCING, false);
    }

    public boolean isDancing() {
        return entityData.get(DANCING);
    }

    private void setDancing(boolean dancing) {
        entityData.set(DANCING, dancing);
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide()) {
            if (this.isDancing()) {
                if (this.dancingTimeLeft-- <= 0) {
                    this.setDancing(false);
                }
            } else {
                if (this.random.nextInt(1000) == 0) {
                    this.setDancing(true);
                    this.dancingTimeLeft = 100 + this.random.nextInt(100);
                }
            }
        }
    }

    public final AnimationState dancingAnimationState = new AnimationState();

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
        super.onSyncedDataUpdated(data);

        if (data == DANCING) {
            this.dancingAnimationState.animateWhen(this.isDancing(), this.tickCount);
        }
    }



//=============================================NBT===================================================
    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
        super.addAdditionalSaveData(valueOutput);
        valueOutput.putInt("dancing_time_left", this.dancingTimeLeft);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
        super.readAdditionalSaveData(valueInput);
        this.dancingTimeLeft = valueInput.getInt("dancing_time_left").orElse(0);
        this.setDancing(this.dancingTimeLeft > 0);
    }

}
