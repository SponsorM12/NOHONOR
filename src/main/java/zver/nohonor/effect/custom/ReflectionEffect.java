package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ReflectionEffect extends MobEffect {
    //ОТРАЖЕНИЕ - Отражает любой снаряд как Бриз или Визер. Вся логика в мискинах
    public ReflectionEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

}