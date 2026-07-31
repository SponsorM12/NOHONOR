package zver.nohonor.mixin.elytra;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.item.ModItems;
//ЭЛИТРЫ
//Надо по своему расписать
//Суть - проверяем на либо Обычные Элитры, либо кастомные
//Если Кастомные - применяем кастомную физику
//Если обычные - применяем обычную ванильную физику

/**
 * Полностью переопределяет ванильную физику полёта на элитрах
 * (LivingEntity#updateFallFlyingMovement) для двух кастомных предметов:
 * STORM_ELYTRA и EXTERMINATION_ELYTRA.
 * <p>
 * Для ванильных элитр и любых других предметов миксин ничего не делает —
 * управление передаётся обратно в оригинальный (ванильный) метод.
 * <p>
 * ВАЖНО (вне зоны ответственности этого файла): чтобы игра вообще позволяла
 * войти в режим планирования (isFallFlying / canGlide), у STORM_ELYTRA и
 * EXTERMINATION_ELYTRA в ModItems должны быть корректно навешаны компоненты
 * DataComponents.GLIDER и DataComponents.EQUIPPABLE(slot = CHEST). Без этого
 * ваниль не вызовет travelFallFlying() и данный Inject не сработает вовсе —
 * стоит перепроверить регистрацию предметов, если полёт не активируется.
 *
 *
 * private Vec3 updateFallFlyingMovement(Vec3 movement) {
 *     Vec3 lookAngle = this.getLookAngle();
 *     float leanAngle = this.getXRot() * ((float)Math.PI / 180F);
 *     double lookHorLength = Math.sqrt(lookAngle.x * lookAngle.x + lookAngle.z * lookAngle.z);
 *     double moveHorLength = movement.horizontalDistance();
 *     double gravity = this.getEffectiveGravity();
 *     double liftForce = Mth.square(Math.cos((double)leanAngle));
 *
 *     // 1. Гравитация/подъёмная сила
 *     movement = movement.add(0.0, gravity * (-1.0 + liftForce * 0.75), 0.0);
 *
 *     // 2. Пикирование (конверсия Y-скорости в горизонтальную)
 *     if (movement.y < 0.0 && lookHorLength > 0.0) {
 *         double convert = movement.y * -0.1 * liftForce;
 *         movement = movement.add(lookAngle.x * convert / lookHorLength, convert, lookAngle.z * convert / lookHorLength);
 *     }
 *
 *     // 3. Набор высоты при взгляде вверх (leanAngle < 0)
 *     if (leanAngle < 0.0F && lookHorLength > 0.0) {
 *         double convert = moveHorLength * (-Mth.sin(leanAngle)) * 0.04;
 *         // ВАЖНО: множитель здесь 3.2, а НЕ 1.0 как в твоей "Storm"-ветке!
 *         movement = movement.add(-lookAngle.x * convert / lookHorLength, convert * 3.2, -lookAngle.z * convert / lookHorLength);
 *     }
 *
 *     // 4. Манёвренность (доводка направления движения к направлению взгляда)
 *     if (lookHorLength > 0.0) {
 *         movement = movement.add(
 *             (lookAngle.x / lookHorLength * moveHorLength - movement.x) * 0.1,
 *             0.0,
 *             (lookAngle.z / lookHorLength * moveHorLength - movement.z) * 0.1
 *         );
 *     }
 *
 *     // 5. Сопротивление воздуха
 *     return movement.multiply(0.99, 0.98, 0.99);
 * }
 */
@Mixin(LivingEntity.class)
public abstract class CustomElytraMixin {

    // =========================================================================================
    //  ШТОРМОВЫЕ ЭЛИТРЫ (STORM_ELYTRA)
    // =========================================================================================

    /** Множитель liftForce в гравитации. ваниль = 0.75 */
    private static final double STORM_LIFT_COEFFICIENT = 0.85;

    /** Делитель гравитации (смягчение). ваниль = 1.0 (деления нет) */
    private static final double STORM_GRAVITY_SOFTENING_DIVISOR = 1.0;

    /** Конверсия пике → горизонтальная скорость. ваниль = 0.1 */
    private static final double STORM_DIVE_TO_SPEED_CONVERSION = 0.1;

    /** База набора высоты. ваниль = 0.04 */
    private static final double STORM_CLIMB_BASE_FACTOR = 0.04;

    /** Множитель набора высоты. ваниль = 3.2 */
    private static final double STORM_CLIMB_MULTIPLIER = 3.2;

    /** Отзывчивость поворота (steering). ваниль = 0.1 */
    private static final double STORM_STEERING_RESPONSIVENESS = 0.03;

    /** Горизонтальное сопротивление воздуха. ваниль = 0.99 */
    private static final double STORM_HORIZONTAL_DRAG = 0.99;

    /** Вертикальное сопротивление воздуха. ваниль = 0.98 */
    private static final double STORM_VERTICAL_DRAG = 0.99;


    // =========================================================================================
    //  ЭЛИТРЫ ИСТРЕБЛЕНИЯ (EXTERMINATION_ELYTRA)
    // =========================================================================================

    /** Множитель liftForce в гравитации. ваниль = 0.75 */
    private static final double EXTERMINATION_LIFT_COEFFICIENT = 0.45;

    /** Множитель гравитации на взлёте (leanAngle < 0). ваниль = 1.0 */
    private static final double EXTERMINATION_GRAVITY_MULTIPLIER_ASCENDING = 1.3;

    /** Множитель гравитации при полёте прямо/вниз. ваниль = 1.0 (аналога нет) */
    private static final double EXTERMINATION_GRAVITY_MULTIPLIER_DESCENDING = 1.0;

    /** Конверсия пике → горизонтальная скорость. ваниль = 0.1 */
    private static final double EXTERMINATION_DIVE_TO_SPEED_CONVERSION = 0.13;

    /** База набора высоты. ваниль = 0.04 */
    private static final double EXTERMINATION_CLIMB_BASE_FACTOR = 0.04;

    /** Множитель набора высоты. ваниль = 3.2 */
    private static final double EXTERMINATION_CLIMB_MULTIPLIER = 2.0;

    /** Отзывчивость поворота (steering). ваниль = 0.1 */
    private static final double EXTERMINATION_STEERING_RESPONSIVENESS = 0.2;

    /** Горизонтальное сопротивление воздуха. ваниль = 0.99 */
    private static final double EXTERMINATION_HORIZONTAL_DRAG = 0.993;

    /** Вертикальное сопротивление воздуха. ваниль = 0.98 */
    private static final double EXTERMINATION_VERTICAL_DRAG = 0.985;

    @Shadow protected abstract double getEffectiveGravity();
    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot slot);

    @Inject(method = "updateFallFlyingMovement", at = @At("HEAD"), cancellable = true)
    private void nohonor$customElytraGlide(Vec3 movement, CallbackInfoReturnable<Vec3> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        ItemStack chestItem = entity.getItemBySlot(EquipmentSlot.CHEST);

        boolean isStorm = chestItem.is(ModItems.STORM_ELYTRA);
        boolean isExtermination = chestItem.is(ModItems.EXTERMINATION_ELYTRA);
        //boolean isStorm = chestItem.is(ModItems.STORM_ELYTRA) || chestItem.is(net.minecraft.world.item.Items.ELYTRA); // ВРЕМЕННО, для теста!


        // Если это не наши кастомные элитры, ничего не делаем (работает ваниль)
        if (!isStorm && !isExtermination) {
            return;
        }


        Vec3 lookAngle = entity.getLookAngle();
        double leanAngle = entity.getXRot() * (Math.PI / 180.0);
        double lookHorLength = Math.sqrt(lookAngle.x * lookAngle.x + lookAngle.z * lookAngle.z);
        double moveHorLength = movement.horizontalDistance();
        double gravity = this.getEffectiveGravity();
        double liftForce = Mth.square(Math.cos(leanAngle));

        Vec3 result = isStorm
                ? computeStormMovement(movement, lookAngle, leanAngle, lookHorLength, moveHorLength, gravity, liftForce)
                : computeExterminationMovement(movement, lookAngle, leanAngle, lookHorLength, moveHorLength, gravity, liftForce);

        cir.setReturnValue(result);
    }

    /** Расчёт движения для штормовых элитр. См. константы STORM_* выше. */
    private Vec3 computeStormMovement(Vec3 movement, Vec3 lookAngle, double leanAngle,
                                      double lookHorLength, double moveHorLength,
                                      double gravity, double liftForce) {
        // 1) Гравитация с учётом подъёмной силы, смягчённая делителем
        movement = movement.add(0.0,
                gravity * ((-1.0 + liftForce * STORM_LIFT_COEFFICIENT) / STORM_GRAVITY_SOFTENING_DIVISOR),
                0.0);

        // 2) Пикирование: конверсия вертикальной скорости в горизонтальную
        if (movement.y < 0.0 && lookHorLength > 0.0) {
            double convert = movement.y * -STORM_DIVE_TO_SPEED_CONVERSION * liftForce;
            movement = movement.add(lookAngle.x * convert / lookHorLength, convert, lookAngle.z * convert / lookHorLength);
        }

        // 3) Набор высоты при взгляде вверх
        if (leanAngle < 0.0 && lookHorLength > 0.0) {
            double convert = moveHorLength * (-Mth.sin(leanAngle)) * STORM_CLIMB_BASE_FACTOR;
            movement = movement.add(-lookAngle.x * convert / lookHorLength, convert * STORM_CLIMB_MULTIPLIER, -lookAngle.z * convert / lookHorLength);
        }

        // 4) Манёвренность: доводка направления движения к направлению взгляда
        if (lookHorLength > 0.0) {
            movement = movement.add(
                    (lookAngle.x / lookHorLength * moveHorLength - movement.x) * STORM_STEERING_RESPONSIVENESS,
                    0.0,
                    (lookAngle.z / lookHorLength * moveHorLength - movement.z) * STORM_STEERING_RESPONSIVENESS
            );
        }

        // 5) Сопротивление воздуха
        return movement.multiply(STORM_HORIZONTAL_DRAG, STORM_VERTICAL_DRAG, STORM_HORIZONTAL_DRAG);
    }

    /** Расчёт движения для элитр истребления. См. константы EXTERMINATION_* выше. */
    private Vec3 computeExterminationMovement(Vec3 movement, Vec3 lookAngle, double leanAngle,
                                              double lookHorLength, double moveHorLength,
                                              double gravity, double liftForce) {
        // 1) Динамическая гравитация: лёгкая на взлёте, тяжёлая при полёте прямо/вниз
        double gravityModifier = (leanAngle < 0.0) ? EXTERMINATION_GRAVITY_MULTIPLIER_ASCENDING : EXTERMINATION_GRAVITY_MULTIPLIER_DESCENDING;
        movement = movement.add(0.0, gravity * ((-1.0 + liftForce * EXTERMINATION_LIFT_COEFFICIENT) * gravityModifier), 0.0);

        // 2) Пикирование: сильная конверсия вертикальной скорости в горизонтальную
        if (movement.y < 0.0 && lookHorLength > 0.0) {
            double convert = movement.y * -EXTERMINATION_DIVE_TO_SPEED_CONVERSION * liftForce;
            movement = movement.add(lookAngle.x * convert / lookHorLength, convert, lookAngle.z * convert / lookHorLength);
        }

        // 3) Набор высоты: множитель совпадает с ванильным (3.2)
        if (leanAngle < 0.0 && lookHorLength > 0.0) {
            double convert = moveHorLength * (-Mth.sin(leanAngle)) * EXTERMINATION_CLIMB_BASE_FACTOR;
            movement = movement.add(-lookAngle.x * convert / lookHorLength, convert * EXTERMINATION_CLIMB_MULTIPLIER, -lookAngle.z * convert / lookHorLength);
        }

        // 4) Манёвренность: резкая доводка направления
        if (lookHorLength > 0.0) {
            movement = movement.add(
                    (lookAngle.x / lookHorLength * moveHorLength - movement.x) * EXTERMINATION_STEERING_RESPONSIVENESS,
                    0.0,
                    (lookAngle.z / lookHorLength * moveHorLength - movement.z) * EXTERMINATION_STEERING_RESPONSIVENESS
            );
        }

        // 5) Сопротивление воздуха
        return movement.multiply(EXTERMINATION_HORIZONTAL_DRAG, EXTERMINATION_VERTICAL_DRAG, EXTERMINATION_HORIZONTAL_DRAG);
    }
}