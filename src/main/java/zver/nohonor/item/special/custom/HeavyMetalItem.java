package zver.nohonor.item.special.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import zver.nohonor.item.ModTooltipItems;
import zver.nohonor.item.special.SpecialItemBehavior;

//Название временное, как и просил — переименуй как решишь.
//Класс намеренно НЕ привязан к одному материалу (в отличие от LumelItem/HellesteroyItem/...) —
//задумывался как общий "тяжёлый металл", применимый сразу к нескольким сплавам мода
public class HeavyMetalItem extends ModTooltipItems implements SpecialItemBehavior {

    //Скорость погружения. Знак и модуль зеркальны Vivarium.TARGET_RISE_SPEED (0.05) —
    //та же "выразительность" эффекта, только вниз, а не вверх
    private static final double SINK_SPEED = -0.05;

    public HeavyMetalItem(String descKey, Properties properties) {
        super(descKey, properties);
    }

    public HeavyMetalItem(String descKey, int descLines, Properties properties) {
        super(descKey, descLines, properties);
    }

    public HeavyMetalItem(int nameColor, Properties properties) {
        super(nameColor, properties);
    }

    public HeavyMetalItem(String descKey, int descLines, Integer nameColor, Properties properties) {
        super(descKey, descLines, nameColor, properties);
    }

    @Override
    public void onEveryTick(ItemEntity itemEntity, ServerLevel level) {
        Vec3 motion = itemEntity.getDeltaMovement();
        boolean grounded = itemEntity.onGround();
        boolean inWater = itemEntity.isInWater();

        double newX = motion.x;
        double newY = motion.y;
        double newZ = motion.z;
        boolean changed = false;

        //МАКСИМАЛЬНОЕ ТРЕНИЕ: любая "сопротивляющаяся" среда (твёрдая земля ИЛИ вода)
        //гасит горизонтальный снос мгновенно, игнорируя реальный коэффициент трения блока
        if ((grounded || inWater) && (motion.x != 0.0 || motion.z != 0.0)) {
            newX = 0.0;
            newZ = 0.0;
            changed = true;
        }

        //ТОНЕТ: пока висит в толще воды (ещё не долетел до дна) — тянем вниз
        //постоянной скоростью вместо ванильной плавучести. На дне (grounded=true)
        //Y не трогаем — там уже держит обычная коллизия с полом
        if (inWater && !grounded && motion.y != SINK_SPEED) {
            newY = SINK_SPEED;
            changed = true;
        }

        if (changed) {
            itemEntity.setDeltaMovement(newX, newY, newZ);
            itemEntity.hurtMarked = true;
        }
    }

}