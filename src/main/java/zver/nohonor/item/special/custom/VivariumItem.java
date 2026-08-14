package zver.nohonor.item.special.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class VivariumItem extends ModTooltipItems implements SpecialItemBehavior {

    private static final double TARGET_RISE_SPEED = 0.05;
    private static final double HORIZONTAL_DAMPING = 0.98;

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

    @Override
    public void onEveryTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.isNoGravity()) {
            itemEntity.setNoGravity(true);
        }

        Vec3 motion = itemEntity.getDeltaMovement();
        itemEntity.setDeltaMovement(
                motion.x * HORIZONTAL_DAMPING,
                TARGET_RISE_SPEED,
                motion.z * HORIZONTAL_DAMPING
        );

        // Обращаемся к публичному полю напрямую в обход protected метода
        itemEntity.hurtMarked = true;
    }

}