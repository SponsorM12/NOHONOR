package zver.nohonor.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

//объяснить вообще всё!!!

public abstract class ModFluid extends FlowingFluid {

    private final boolean source;

    protected ModFluid(boolean source) {
        this.source = source;
    }

    @Override
    protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
        super.createFluidStateDefinition(builder);
        if (!source) {
            builder.add(LEVEL);
        }
    }

    @Override
    public int getAmount(FluidState state) {
        return source ? 8 : state.getValue(LEVEL);
    }

    @Override
    public boolean isSource(FluidState state) {
        return source;
    }

    //поведение "как у воды"
    @Nullable
    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean canConvertToSource(ServerLevel world) {
        return world.getGameRules().get(GameRules.WATER_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropResources(state, world, pos, blockEntity);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader world) {
        return 4;
    }

    @Override
    public int getDropOff(LevelReader world) {
        return 1;
    }

    @Override
    public int getTickDelay(LevelReader world) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }

    protected abstract Supplier<? extends Fluid> stillFluid();
    protected abstract Supplier<? extends Fluid> flowingFluid();
    protected abstract Supplier<? extends Block> liquidBlock();
    protected abstract Supplier<? extends Item> bucketItem();
    protected abstract TagKey<Fluid> fluidTag();

    @Override
    public Fluid getFlowing() {
        return flowingFluid().get();
    }

    @Override
    public Fluid getSource() {
        return stillFluid().get();
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == getSource() || fluid == getFlowing();
    }

    @Override
    public Item getBucket() {
        return bucketItem().get();
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockGetter world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(fluidTag());
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return liquidBlock().get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }

}