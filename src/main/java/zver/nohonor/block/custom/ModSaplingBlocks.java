// zver/nohonor/block/custom/ModSaplingBlock.java
package zver.nohonor.block.custom;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModSaplingBlocks extends SaplingBlock {

    public ModSaplingBlocks(TreeGrower grower, BlockBehaviour.Properties properties) {
        super(grower, properties);
    }

    //@Override
    //public BlockState updateShape (BlockState state, Direction direction, BlockState neighorState,
    //                               LevelAccessor level, BlockPos currentPos, BlockPos neighPos){
    //    return !state.canSurvive(level, currentPos)
    //            ? Blocks.AIR.defaultBlockState()
    //            : super.updateShape(state, direction, neighorState, level, neighPos);
    //    }

}