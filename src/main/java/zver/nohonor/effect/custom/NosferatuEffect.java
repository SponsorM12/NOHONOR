package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NosferatuEffect extends MobEffect {
    //НОСФЕРАТУ - вампиризм. Только для ближнего боя. ~12,5% восстановления здоровья от нанесенного
    //урона. При этом нельзя вытянуть условно 20 хп востановленного урона при превосходящем уроне
    //по курице с 4 хп
    public NosferatuEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

}