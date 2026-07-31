package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DisarmEffect extends MobEffect {
    //ОБЕЗОРУЖИВАНИЕ - запрещает буквально использовать Левую кнопку мыши
    //то есть натурально запрещает копать, бить и делать иные вещи, которые можно делать ЛКМ
    //запрещает атк же мобам атаковать
    //запрещает делаеть действия не только игроку но и запрещает мобам атаковать
    public DisarmEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
}