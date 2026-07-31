package zver.nohonor.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import zver.nohonor.item.custom.consume_effect.DrainHungerConsumeEffect;
import zver.nohonor.item.custom.consume_effect.RestoreSaturationConsumeEffect;

public class ModFoods {
//НУТРИЕН ЭТО 1 к 1 ГОЛОД
//ВЫСЧИТЫВАТЬ ИЗ 20
//САТУРЕЙШН ВЫСЧИТЫВАЕТСЯ КАК МНОЖИТЕЛЬ
//Насыщение = nutrition × saturationModifier
//МАКСИМАЛЬНОЕ ЗНАЧЕНИЕ НАСЫЩЕНИЯ 30 (?)
//1.0f = *2
    //Я НЕ ПОНИМАЮ КАК СЧИТАТЬ
//====================================="ДЕФОЛТ" ЕДА====================================
    public static final FoodProperties BLANK_FOOD = new FoodProperties.Builder()
        //.nutrition(2)             //сколько единиц голода восстанавливает
        //.saturationModifier(0.2f) //насыщение
        .alwaysEdible()        //есть даже с полным голодом
        .build();

    //public static final Consumable GNILAYA_EDA = Consumables.defaultFood()
    //        .consumeSeconds(1.6f)
   //        .onConsume(new DrainHungerConsumeEffect(4, 2.0f)) // отнять 4 голода и 2.0 сытости
    //        .build();

    public static final FoodProperties NUTRITIONAL_JELLY = new FoodProperties.Builder()
            .nutrition(1)
            .alwaysEdible()
            .build();

    public static final FoodProperties HEARTY_JELLY = new FoodProperties.Builder()
            .saturationModifier(1f)
            .alwaysEdible()
            .build();


    public static final FoodProperties ROTTEN_JELLY = new FoodProperties.Builder()
            .alwaysEdible()
            .build();

    public static final FoodProperties SPOILED_JELLY = new FoodProperties.Builder()
            .alwaysEdible()
            .build();

    public static final FoodProperties FRUM_FRUM = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0f)
            .alwaysEdible()
            .build();

    public static final FoodProperties GREEN_APPLE = new FoodProperties.Builder()
            .nutrition(3)             //сколько единиц голода восстанавливает
            .saturationModifier(0.7f) //насыщение
            //.alwaysEdible()
            .build();

    public static final FoodProperties MAKOSH_BERRIES = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(2.0f)
            .alwaysEdible()
            .build();

    public static final FoodProperties RICE_SHOOT = new FoodProperties.Builder()
            .nutrition(1)
            //.saturationModifier(1.0f)
            .build();

    public static final FoodProperties ADVACADO = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.2f)
            .build();

    public static final FoodProperties SHAWARMA = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1.0f)
            .build();


//КОНСТРУКТОР:
// new MobEffectInstance(
//    MobEffect effect,
//    int duration,
//    int amplifier,
//    boolean ambient,
//    boolean showParticles,
//    boolean showIcon
//)
    //КОНСУМАБЛЫ
    public static final Consumable NUTRITIONAL_JELLY_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.1f)
            .build();

    public static final Consumable HEARTY_JELLY_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.1f)
            .onConsume(new RestoreSaturationConsumeEffect(1.0f))
            .build();

    public static final Consumable ROTTEN_JELLY_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new DrainHungerConsumeEffect(1, 0f))
            .consumeSeconds(0.1f)
            .build();

    public static final Consumable SPOILED_JELLY_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new DrainHungerConsumeEffect(0, 1f))
            .consumeSeconds(0.1f)
            .build();

    public static final Consumable FRUM_FRUM_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(3.2f)
            .onConsume(new DrainHungerConsumeEffect(8, 6.0f)) // отнять 8 голода и 6.0 сытости
            .build();

    public static final Consumable MAKOSH_BERRIES_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.8f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(
                    MobEffects.INSTANT_HEALTH, 1, 1, false, false, false)))
            .build();

    public static final Consumable ADVACADO_COMSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .build();

    public static final Consumable SHAWARMA_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(
                    MobEffects.INSTANT_HEALTH, 1, 1, false, false, false)))
            .build();

//==================================="СТОЙКАЯ" ЕДА=====================================
    public static final FoodProperties RICE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(1.0f)
            .alwaysEdible()
            .build();

    public static final FoodProperties ONIGIRI = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .build();

    public static final FoodProperties SUSHI = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .build();

    public static final FoodProperties MEBER_APPLE = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .build();

    public static final FoodProperties SPACE_WATERMELON = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(1.8f)
            .alwaysEdible()
            .build();

    //КОНСУМАБЛЫ
    public static final Consumable RICE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.8f)
            .build();

    public static final Consumable BEANS_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(4.8f)
            .build();

    public static final Consumable SUSHI_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .build();

    public static final Consumable ONIGIRI_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .build();

    public static final Consumable MEBER_APPLE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(
                    MobEffects.RESISTANCE, 400, 1, true, true, true)))
            .build();

    public static final Consumable SPACE_WATERMELON_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .build();

}