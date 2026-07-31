package zver.nohonor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class ModShelfBlocks extends ShelfBlock {

    public ModShelfBlocks(BlockBehaviour.Properties properties) {
        super(properties);
    }

    //ТО ЕСТЬ МЫ ПРОСТО БЕРЕМ КОПИЮ ВАНИЛЬНОГО Shelf?
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }
}