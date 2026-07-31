// HesperidesDoorBlock.java
package zver.nohonor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class ModDoorBlocks extends DoorBlock {

    //ПЕРЕДЕЛАТЬ, ПРОВЕРИТЬ НА БАГИ

    public ModDoorBlocks(BlockSetType blockSetType, BlockBehaviour.Properties properties) {
        super(blockSetType, properties);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState below = level.getBlockState(pos.below());
            //Верхняя половина выживает если под ней нижняя половина ЭТОЙ же двери
            return below.is(this) && below.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
        //Нижняя половина — стандартная проверка твёрдой опоры снизу
        return level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP);
    }
}