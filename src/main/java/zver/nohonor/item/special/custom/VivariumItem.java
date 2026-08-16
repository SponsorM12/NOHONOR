package zver.nohonor.item.special.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

public class VivariumItem extends ModTooltipItems implements SpecialItemBehavior {

    private static final double TARGET_RISE_SPEED = 0.05;
    private static final double HORIZONTAL_DAMPING = 0.98;
    private static final double SETTLE_EPSILON = 1.0E-4; //ниже этого горизонтальный снос считаем нулевым

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

        boolean horizontalSettled = Math.abs(motion.x) < SETTLE_EPSILON && Math.abs(motion.z) < SETTLE_EPSILON;
        boolean verticalSettled = motion.y == TARGET_RISE_SPEED;

        //Уже в целевом состоянии (чистый подъём без сноса) — писать нечего,
        //экономим и Vec3-аллокацию, и лишний ClientboundSetEntityMotionPacket всем наблюдателям
        if (horizontalSettled && verticalSettled) {
            return;
        }

        double newX = horizontalSettled ? 0.0 : motion.x * HORIZONTAL_DAMPING;
        double newZ = horizontalSettled ? 0.0 : motion.z * HORIZONTAL_DAMPING;

        itemEntity.setDeltaMovement(newX, TARGET_RISE_SPEED, newZ);
        itemEntity.hurtMarked = true;
    }

}