package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ImmunityEffect extends MobEffect {
    //ИММУНИТЕТ - то же самое, что и Curse, только делает наоборот - запрещает накдалывание
    //новых отрицательных вредных эффектов
    public ImmunityEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
}