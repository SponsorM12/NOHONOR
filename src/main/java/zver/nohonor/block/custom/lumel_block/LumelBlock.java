package zver.nohonor.block.custom.lumel_block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class LumelBlock extends Block {

    private static final int RADIUS = 1;
    private static final int TICK_DELAY = 40;

    public LumelBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide()) {
            level.scheduleTick(pos, this, TICK_DELAY);
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        for (BlockPos target : BlockPos.betweenClosed(
                pos.offset(-RADIUS, -RADIUS, -RADIUS), pos.offset(RADIUS, RADIUS, RADIUS))) {
            BlockState targetState = level.getBlockState(target);
            if (targetState.getFluidState().isSource() && targetState.getFluidState().is(FluidTags.WATER)) {
                level.setBlockAndUpdate(target.immutable(), Blocks.ICE.defaultBlockState());
            }
        }
        level.scheduleTick(pos, this, TICK_DELAY);
    }

}