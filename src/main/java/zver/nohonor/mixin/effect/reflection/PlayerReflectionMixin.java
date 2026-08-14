package zver.nohonor.mixin.effect.reflection;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.custom_mechanics.reflection.ReflectionData;
import zver.nohonor.effect.ModEffects;

@Mixin(Player.class)
public abstract class PlayerReflectionMixin implements ReflectionData {

    @Unique
    private static final EntityDataAccessor<Boolean> REFLECTING =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.BOOLEAN);

    @Unique
    private static final EntityDataAccessor<Integer> REFLECTION_AMPLIFIER =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.INT);

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void nohonor$defineReflectionData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(REFLECTING, false);
        builder.define(REFLECTION_AMPLIFIER, 0);
    }

    @Override
    public boolean isReflecting() {
        Player self = (Player) (Object) this;
        return self.getEntityData().get(REFLECTING);
    }

    @Override
    public void setReflecting(boolean reflecting) {
        Player self = (Player) (Object) this;
        self.getEntityData().set(REFLECTING, reflecting);
    }

    @Override
    public int getReflectionAmplifier() {
        Player self = (Player) (Object) this;
        return self.getEntityData().get(REFLECTION_AMPLIFIER);
    }

    @Override
    public void setReflectionAmplifier(int amplifier) {
        Player self = (Player) (Object) this;
        self.getEntityData().set(REFLECTION_AMPLIFIER, amplifier);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void nohonor$resyncReflectionOnLoad(ValueInput input, CallbackInfo ci) {
        Player self = (Player) (Object) this;
        boolean hasEffect = self.hasEffect(ModEffects.REFLECTION);
        this.setReflecting(hasEffect);
        if (hasEffect) {
            MobEffectInstance effect = self.getEffect(ModEffects.REFLECTION);
            this.setReflectionAmplifier(effect != null ? effect.getAmplifier() : 0);
        } else {
            this.setReflectionAmplifier(0);
        }
    }

}