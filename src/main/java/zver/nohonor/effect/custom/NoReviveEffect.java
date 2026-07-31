package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NoReviveEffect extends MobEffect {
    //ЗАПРЕТ НА ВОСКРЕШЕНИЕ - эффект соответствует названию. Блокирует триггер Тотема, даже если их оба в руках
    //работает даже на мобов, проверено на лисе
    //тотем при этом не тратится при "смерти"
    public NoReviveEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
}