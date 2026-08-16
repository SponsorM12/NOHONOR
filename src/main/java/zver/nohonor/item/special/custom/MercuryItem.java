package zver.nohonor.item.special.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

import java.util.Map;
import java.util.WeakHashMap;

public class MercuryItem extends ModTooltipItems implements SpecialItemBehavior {

    //Ниже этого порога считаем предмет остановившимся — не пытаемся ничего компенсировать,
    //иначе деление на почти-ноль даст абсурдный scale
    private static final double MIN_TRACKED_SPEED = 1.0E-4;

    //Защита от разгона после столкновений со стеной — та же логика,
    //что и в EntityReflectionDeflectMixin ("кап скорости = 16 блоков в тик")
    private static final double MAX_TRACKED_SPEED = 1.5;

    //Хранит целевую горизонтальную скорость каждой брошенной ртути отдельно.
    //WeakHashMap: запись пропадает сама, когда ItemEntity больше нигде не держится
    //(подобрали, задеспаунился) — явно чистить не нужно
    private static final Map<ItemEntity, Double> TRACKED_SPEED = new WeakHashMap<>();

    public MercuryItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public MercuryItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public MercuryItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public MercuryItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public void onEveryTick(ItemEntity itemEntity, ServerLevel level) {
        if (!itemEntity.onGround()) {
            //В воздухе/воде трение блока и так не действует — нечего компенсировать
            return;
        }

        Vec3 motion = itemEntity.getDeltaMovement();
        double horizontalSpeed = Math.sqrt(motion.x * motion.x + motion.z * motion.z);

        if (horizontalSpeed < MIN_TRACKED_SPEED) {
            //Реально остановился (например врезался в стену) — забываем цель, начинаем заново
            TRACKED_SPEED.remove(itemEntity);
            return;
        }

        Double tracked = TRACKED_SPEED.get(itemEntity);

        if (tracked == null || horizontalSpeed >= tracked) {
            //Скорость не упала с прошлого тика (новый бросок/пинок) — просто запоминаем её как цель
            TRACKED_SPEED.put(itemEntity, Math.min(horizontalSpeed, MAX_TRACKED_SPEED));
            return;
        }

        //Трение уже подрезало скорость за этот тик — восстанавливаем направление,
        //но возвращаем магнитуду к запомненной цели. Эффект: скольжение без затухания, как по льду
        double target = Math.min(tracked, MAX_TRACKED_SPEED);
        double scale = target / horizontalSpeed;

        itemEntity.setDeltaMovement(motion.x * scale, motion.y, motion.z * scale);
        itemEntity.hurtMarked = true; //форсируем синк скорости клиентам
    }

}
