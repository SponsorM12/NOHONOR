package zver.nohonor.block.custom.hellesteroy_block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class HellesteroyBlock extends Block {

    private static final int RADIUS = 1;
    private static final int TICK_DELAY = 40;

    public HellesteroyBlock(Properties properties) {
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
            if (level.isEmptyBlock(target) && !level.getBlockState(target.below()).isAir()) {
                level.setBlockAndUpdate(target.immutable(), Blocks.FIRE.defaultBlockState());
            }
        }
        level.scheduleTick(pos, this, TICK_DELAY);
    }

}