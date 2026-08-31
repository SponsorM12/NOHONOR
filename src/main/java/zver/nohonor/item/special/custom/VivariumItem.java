package zver.nohonor.item.special.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.FloatingItemBehavior;
import zver.nohonor.item.special.SpecialItemBehavior;

public class VivariumItem extends ModTooltipItems implements SpecialItemBehavior {

    @Override
    public void onEveryTick(ItemEntity itemEntity, ServerLevel level) {
        FloatingItemBehavior.applyRise(itemEntity);
    }

    public VivariumItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public VivariumItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public VivariumItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public VivariumItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }


}