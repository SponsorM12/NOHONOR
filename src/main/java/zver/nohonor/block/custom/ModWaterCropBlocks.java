package zver.nohonor.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.item.ModItems;

import java.util.function.Supplier;

public class ModWaterCropBlocks extends CropBlock {

    private final Supplier<ItemLike> seed;
    private final Supplier<Block> stem;

    public ModWaterCropBlocks(Properties properties, Supplier<ItemLike> seed, Supplier<Block> stem) {
        super(properties);
        this.seed = seed;
        this.stem = stem;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.seed.get();
    }

    @Override
    public Item asItem() {
        return this.seed.get().asItem();
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState stateBelow = level.getBlockState(pos.below());
        return stateBelow.is(this.stem.get());
    }

    //@Override
    //protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
    //    return state.is(ModBlocks.RICE_STEM);
    //}

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Проверяем уровень освещенности (поставлены ванильные значения)
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                //Ванильная скорость роста
                //random.nextInt(3) == 0 дает шанс роста ~33% за один random tick
                if (random.nextInt(3) == 0) {
                    level.setBlock(pos, this.getStateForAge(age + 1), 2);
                }
            }
        }

    }

}