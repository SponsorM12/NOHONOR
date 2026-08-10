package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class GreekFireEffect extends MobEffect {
    //ГРЕЧЕСКИЙ ОГОНЬ - сам по себе ничего не делает, но если подожжен - увеличивает урон от огня
    //а так же огонь становится невозможно потушить. Логика в миксинах
        public GreekFireEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

}
