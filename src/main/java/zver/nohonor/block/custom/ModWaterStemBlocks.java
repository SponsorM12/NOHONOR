package zver.nohonor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.FlowingFluid;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;


//в чем соль:
//есть блок Стебля, который находится под водой на конкретном блоке
//блок  должен быть "пригодным" именно для этого Стебля
//далее Стебель спавнит над собой Кроп, уже который можно собирать как урожай
//Если сбить Кроп, то Стебель заспавнит новый через время
//Если сбить Стебель, то Кроп соберется и тоже сломается
//Кроп - отдельный блок, смотри waterCrop
//Стебель обязан быть в жидкости
//Настроено так, чтобы можно было выбирать в какой жидкости
//

public class ModWaterStemBlocks extends Block {
    private final Supplier<Block> cropBlock;
    private final Supplier<Fluid> sourceFluid;
    private final TagKey<Fluid> fluidTag;
    private final Supplier<Block[]> validGroundBlocks;

    public ModWaterStemBlocks(Properties properties, Supplier<Block> cropBlock, Supplier<Fluid> sourceFluid, TagKey<Fluid> fluidTag, Supplier<Block[]> validGroundBlocks) {
        super(properties);
        this.cropBlock = cropBlock;
        this.sourceFluid = sourceFluid;
        this.fluidTag = fluidTag;
        this.validGroundBlocks = validGroundBlocks;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        //Блок всегда логически содержит свою жидкость в клетке
        return ((FlowingFluid) this.sourceFluid.get()).getSource(false);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        if (!fluidState.is(this.fluidTag) || fluidState.getAmount() != 8) {
            return null;
        }
        return super.getStateForPlacement(context);
    }

    //Провертка на конкретную почву
    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        boolean validGround = false;
        for (Block block : validGroundBlocks.get()) {
            if (below.is(block)) {
                validGround = true;
                break;
            }
        }
        return validGround && level.getFluidState(pos).is(this.fluidTag);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (!this.canSurvive(state, level, pos)) {
            //Блок мгновенно пропадает, а соседняя настоящая жидкость сама затечёт
            return Blocks.AIR.defaultBlockState();
        }
        FluidState fluidState = state.getFluidState();
        if (!fluidState.isEmpty()) {
            //Стебель делает жидкость Источником - от него жидкость может растекатся
            ticks.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(level));
        }
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.canSurvive(state, level, pos)) {
            return;
        }
        BlockPos abovePos = pos.above();
        if (level.getBlockState(abovePos).isAir()) {
            level.setBlockAndUpdate(abovePos, this.cropBlock.get().defaultBlockState());
        }
    }
}
