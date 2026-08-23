package zver.nohonor.entity.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.entity.ModEntityTypes;

public class RisingBlockEntity extends Entity {

    private static final int MAX_LIFETIME = 600;
    private static final EntityDataAccessor<BlockPos> DATA_START_POS =
            SynchedEntityData.defineId(RisingBlockEntity.class, EntityDataSerializers.BLOCK_POS);

    private BlockState blockState = Blocks.AIR.defaultBlockState();
    private int time;

    public RisingBlockEntity(EntityType<RisingBlockEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected Component getTypeName() {
        return Component.translatable("entity.nohonor.rising_block_type", this.blockState.getBlock().getName());
    }

    public static RisingBlockEntity rise(Level level, BlockPos pos, BlockState state) {
        RisingBlockEntity entity = new RisingBlockEntity(ModEntityTypes.RISING_BLOCK, level);
        entity.blockState = state;
        entity.blocksBuilding = true;
        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        entity.setDeltaMovement(Vec3.ZERO);
        entity.xo = entity.getX();
        entity.yo = entity.getY();
        entity.zo = entity.getZ();
        entity.entityData.set(DATA_START_POS, pos);

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        level.addFreshEntity(entity);
        return entity;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(DATA_START_POS, BlockPos.ZERO);
    }

    @Override
    public final boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        if (!this.isInvulnerableToBase(source)) {
            this.markHurt();
        }
        return false;
    }

    @Override
    public void tick() {
        if (this.blockState.isAir()) {
            this.discard();
            return;
        }

        ++this.time;
        this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.04, 0.0));
        this.move(MoverType.SELF, this.getDeltaMovement());

        if (this.level() instanceof ServerLevel serverLevel) {
            BlockPos pos = this.blockPosition();
            boolean blockedAbove = !serverLevel.getBlockState(pos.above()).isAir();

            if (blockedAbove) {
                this.setDeltaMovement(Vec3.ZERO);
                if (serverLevel.getBlockState(pos).canBeReplaced()) {
                    serverLevel.setBlock(pos, this.blockState, 3);
                }
                this.discard();
            } else if (this.time > MAX_LIFETIME || pos.getY() > serverLevel.getMaxY()) {
                this.discard();
            }
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        output.store("BlockState", BlockState.CODEC, this.blockState);
        output.putInt("Time", this.time);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        this.blockState = input.read("BlockState", BlockState.CODEC).orElse(Blocks.AIR.defaultBlockState());
        this.time = input.getIntOr("Time", 0);
    }

    public BlockState getBlockState() {
        return this.blockState;
    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    @Override
    public boolean isPickable() {
        return !this.isRemoved();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity, Block.getId(this.getBlockState()));
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.blockState = Block.stateById(packet.getData());
        this.blocksBuilding = true;
        this.setPos(packet.getX(), packet.getY(), packet.getZ());
    }

}