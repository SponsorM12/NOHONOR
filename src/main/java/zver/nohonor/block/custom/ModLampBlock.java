package zver.nohonor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

public class ModLampBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public ModLampBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.stateDefinition.any().setValue(CLICKED, false));
    }

    //Эта позволяет активировать лампу буквально с руки
    //@Override
    //protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult) {
     //   level.setBlockAndUpdate(pos, state.cycle(CLICKED));
    //    return InteractionResult.SUCCESS;
    //}

    //Это делает, чтобы блок был источником редстоуна
    //@Override
    //protected boolean isSignalSource(BlockState state) {
    //    // true, если блок сам должен учитываться как источник сигнала (не обязателен для простой лампы)
    //    return false;
    //}

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(CLICKED, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }


    //Как я понял, есть onPlace, а есть getState, и это разные вещи, хотя и делают одно и то же. Ванильныая лампа использует getState
    //@Override
    //protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
    //    if (oldState.is(state.getBlock())) {
    //        return;
     //   }
   //    boolean powered = level.hasNeighborSignal(pos);
    //    if (powered != state.getValue(CLICKED)) {
    //        level.setBlockAndUpdate(pos, state.setValue(CLICKED, powered));
    //    }
    //}

    //Проверяем соседей на редстоун
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock,
                                   @Nullable Orientation orientation, boolean movedByPiston) {
        boolean powered = level.hasNeighborSignal(pos);
        boolean clicked = state.getValue(CLICKED);

        if (powered != clicked) {
            level.setBlockAndUpdate(pos, state.setValue(CLICKED, powered));
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }

}
