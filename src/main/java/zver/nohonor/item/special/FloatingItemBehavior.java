package zver.nohonor.item.special;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;

//Общая логика "медленно всплывающего предмета" — раньше дословно дублировалась
//в VivariumItem и VivariumBlockItem. Параметризовано на случай, если позже
//понадобится другая скорость всплытия — HeavyMetalItem уже зеркалит эти же
//константы в обратную сторону (тонет вместо всплытия), так что общий кусок
//логике имеет смысл держать переиспользуемым, а не привязанным к одним числам
public final class FloatingItemBehavior {

    private static final double DEFAULT_RISE_SPEED = 0.05;
    private static final double DEFAULT_HORIZONTAL_DAMPING = 0.98;
    private static final double DEFAULT_SETTLE_EPSILON = 1.0E-4;

    private FloatingItemBehavior() {}

    public static void applyRise(ItemEntity itemEntity) {
        applyRise(itemEntity, DEFAULT_RISE_SPEED, DEFAULT_HORIZONTAL_DAMPING, DEFAULT_SETTLE_EPSILON);
    }

    public static void applyRise(ItemEntity itemEntity, double targetRiseSpeed, double horizontalDamping, double settleEpsilon) {
        if (!itemEntity.isNoGravity()) {
            itemEntity.setNoGravity(true);
        }

        Vec3 motion = itemEntity.getDeltaMovement();

        boolean horizontalSettled = Math.abs(motion.x) < settleEpsilon && Math.abs(motion.z) < settleEpsilon;
        boolean verticalSettled = motion.y == targetRiseSpeed;

        //Уже в целевом состоянии — писать нечего, экономим и Vec3-аллокацию,
        //и лишний ClientboundSetEntityMotionPacket всем наблюдателям
        if (horizontalSettled && verticalSettled) {
            return;
        }

        double newX = horizontalSettled ? 0.0 : motion.x * horizontalDamping;
        double newZ = horizontalSettled ? 0.0 : motion.z * horizontalDamping;

        itemEntity.setDeltaMovement(newX, targetRiseSpeed, newZ);
        itemEntity.hurtMarked = true;
    }

}
