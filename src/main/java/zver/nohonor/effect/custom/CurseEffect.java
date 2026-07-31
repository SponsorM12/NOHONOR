package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class CurseEffect extends MobEffect {
    //ПРОКЯТИЕ - запрещает накладывание Положительных полезных эффектов, но не очищает их
    //то есть механика - если на игроке уже есть положительный эффект, то Curse его не снимет
    //он блокирует появление новых эффектов
    //всё поведение в mixin
    public CurseEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
}