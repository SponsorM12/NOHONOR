package zver.nohonor.item.special.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class HellesteroyItem extends ModTooltipItems implements SpecialItemBehavior {

    public HellesteroyItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public HellesteroyItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public HellesteroyItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public HellesteroyItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public void onWorldTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.onGround()) return;

        BlockPos feet = itemEntity.blockPosition();
        if (level.isEmptyBlock(feet) && !level.getBlockState(feet.below()).isAir()) {
            level.setBlockAndUpdate(feet, Blocks.FIRE.defaultBlockState());
        }
    }

}