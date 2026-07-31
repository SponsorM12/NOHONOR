package zver.nohonor.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class NonFlyWeatherEffect extends MobEffect {
    //НЕЛЕТНАЯ ПОГОДА - запрещает ракрывать элитры, и соответственно, летать
    //есть идея сделать этот эффект распространенным и на мобов,
    //но реализация абсурд - у каждого летающего моба свой ai полёта. То есть для каждого летающего моба нужно вручную блокировать полет
    //можно сделать так чтобы блокировался полёт от Креатива и даже Спектатора, но ради дебага не реализуем
    public NonFlyWeatherEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
}