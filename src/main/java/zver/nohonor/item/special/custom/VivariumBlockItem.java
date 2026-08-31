package zver.nohonor.item.special.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.special.FloatingItemBehavior;
import zver.nohonor.item.special.SpecialItemBehavior;

public class VivariumBlockItem extends BlockItem implements SpecialItemBehavior {

    @Override
    public void onEveryTick(ItemEntity itemEntity, ServerLevel level) {
        FloatingItemBehavior.applyRise(itemEntity);
    }

    public VivariumBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

}