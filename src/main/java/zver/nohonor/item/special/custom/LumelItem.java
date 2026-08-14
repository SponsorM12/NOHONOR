package zver.nohonor.item.special.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class LumelItem extends ModTooltipItems implements SpecialItemBehavior {

    public LumelItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public LumelItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public LumelItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public LumelItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public void onWorldTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.isInWater()) return;

        BlockPos pos = itemEntity.blockPosition();
        BlockState state = level.getBlockState(pos);

        // именно источник воды, а не waterlogged-блок и не что-то ещё
        if (!state.is(Blocks.WATER)) return;

        level.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
        level.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GLASS_BREAK,
                SoundSource.NEUTRAL, 1.0f, 1.2f);
    }

}