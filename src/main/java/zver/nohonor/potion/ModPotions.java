package zver.nohonor.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import zver.nohonor.NOHONOR;
import zver.nohonor.effect.ModEffects;

public class ModPotions {
//ПОТКИ
//================================ВАНИЛЬНЫЕ ЗЕЛЬЯ+ АБСУРДНЫЕ ЗЕЛЬЯ=======================================
//=================================================УДАЧА 5==============================================
    public static final Holder<Potion> LONG_LUCK_POTION = registerPotion("long_luck",
            new Potion("long_luck", new MobEffectInstance(ModEffects.LUCK,
                    12000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_LUCK_POTION = registerPotion("strong_luck",
            new Potion("strong_luck", new MobEffectInstance(ModEffects.LUCK,
                    3000,
                    1,
                    true,
                    true
            )));

    public static final Holder<Potion> ABSURD_LUCK_POTION = registerPotion("absurd_luck",
            new Potion("absurd_luck", new MobEffectInstance(MobEffects.LUCK,
                    1200,
                    4,
                    true,
                    true
            )));

//================================================СИЛА 5==============================================
    public static final Holder<Potion> ABSURD_STRENGTH_POTION = registerPotion("absurd_strength",
            new Potion("absurd_strength", new MobEffectInstance(MobEffects.STRENGTH,
                    200,
                    4,
                    true,
                    true
            )));


//===============================================ПОГЛОЩЕНИЕ 5==========================================
    public static final Holder<Potion> ABSORPTION_POTION = registerPotion("absorption",
            new Potion("absorption", new MobEffectInstance(ModEffects.ABSORPTION,
                    6000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_ABSORPTION_POTION = registerPotion("long_absorption",
            new Potion("long_absorption", new MobEffectInstance(ModEffects.ABSORPTION,
                    12000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_ABSORPTION_POTION = registerPotion("strong_absorption",
            new Potion("strong_absorption", new MobEffectInstance(ModEffects.ABSORPTION,
                    3000,
                    1,
                    true,
                    true
            )));

    public static final Holder<Potion> ABSURD_ABSORPTION_POTION = registerPotion("absurd_absorption",
            new Potion("absurd_absorption", new MobEffectInstance(MobEffects.ABSORPTION,
                    1200,
                    4,
                    true,
                    true
            )));

//==============================================ТЬМА==============================================
    public static final Holder<Potion> DARKNESS_POTION = registerPotion("darkness",
            new Potion("darkness", new MobEffectInstance(ModEffects.DARKNESS,
                    200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_DARKNESS_POTION = registerPotion("long_darkness",
            new Potion("long_darkness", new MobEffectInstance(ModEffects.DARKNESS,
                    400,
                    0,
                    true,
                    true
            )));

//==============================================ДИЛЬФИН 5==============================================
    public static final Holder<Potion> DOLPHINS_GRACE_POTION = registerPotion("dolphins_grace",
            new Potion("dolphins_grace", new MobEffectInstance(ModEffects.DOLPHINS_GRACE,
                    2400,
                    0,
                    true,
                 true
            )));

    public static final Holder<Potion> LONG_DOLPHINS_GRACE_POTION = registerPotion("long_dolphins_grace",
            new Potion("long_dolphins_grace", new MobEffectInstance(ModEffects.DOLPHINS_GRACE,
                    4800,
                    0,
                    true,
                    true
            )));

//=========================================ХЕАЛТХ БУСТ ЗДОРОВЬЯ==========================================
    public static final Holder<Potion> HEALTH_BOOST_POTION = registerPotion("health_boost",
            new Potion("health_boost", new MobEffectInstance(ModEffects.HEALTH_BOOST,
                    6000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_HEALTH_BOOST_POTION = registerPotion("long_health_boost",
            new Potion("long_health_boost", new MobEffectInstance(ModEffects.HEALTH_BOOST,
                    12000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_HEALTH_BOOST_POTION = registerPotion("strong_health_boost",
            new Potion("strong_health_boost", new MobEffectInstance(ModEffects.HEALTH_BOOST,
                    3000,
                    1,
                    true,
                    true
            )));

    public static final Holder<Potion> ABSURD_HEALTH_BOOST_POTION = registerPotion("absurd_health_boost",
            new Potion("absurd_health_boost", new MobEffectInstance(MobEffects.HEALTH_BOOST,
                    1200,
                    4,
                    true,
                    true
            )));

//=============================================ИССУШЕНИЕ=============================================
    public static final Holder<Potion> WITHERING_POTION = registerPotion("withering",
            new Potion("withering", new MobEffectInstance(ModEffects.WITHER,
                    200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_WITHERING_POTION = registerPotion("long_withering",
            new Potion("long_withering", new MobEffectInstance(ModEffects.WITHER,
                    400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_WITHERING_POTION = registerPotion("strong_withering",
            new Potion("strong_withering", new MobEffectInstance(ModEffects.WITHER,
                    100,
                    1,
                    true,
                    true
            )));

//================================================КАСТОМ========================================================
//================================================РАСКОЛ=======================================================
    public static final Holder<Potion> SHATTER_POTION = registerPotion("shatter",
            new Potion("shatter", new MobEffectInstance(ModEffects.SHATTER,
                    1200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_SHATTER_POTION = registerPotion("long_shatter",
            new Potion("long_shatter", new MobEffectInstance(ModEffects.SHATTER,
                    2400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_SHATTER_POTION = registerPotion("strong_shatter",
            new Potion("strong_shatter", new MobEffectInstance(ModEffects.SHATTER,
                    600,
                    1,
                    true,
                    true
            )));

//===============================================ОЖОГ==============================================
    public static final Holder<Potion> SCORCH_POTION = registerPotion("scorch",
            new Potion("scorch", new MobEffectInstance(ModEffects.SCORCH,
                1200,
                0,
                true,
                true
            )));

    public static final Holder<Potion> LONG_SCORCH_POTION = registerPotion("long_scorch",
            new Potion("long_scorch", new MobEffectInstance(ModEffects.SCORCH,
                    2400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_SCORCH_POTION = registerPotion("strong_scorch",
            new Potion("strong_scorch", new MobEffectInstance(ModEffects.SCORCH,
                    600,
                    1,
                    true,
                    true
            )));

//=============================================ТЕНАСИТИ СТОЙКОСТЬ============================================
    public static final Holder<Potion> TENACITY_INSTANT_POTION = registerPotion("tenacity_burst",
            new Potion("tenacity_burst", new MobEffectInstance(ModEffects.TENACITY_BURST,
                    1,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_TENACITY_INSTANT_POTION = registerPotion("strong_tenacity_burst",
            new Potion("strong_tenacity_burst", new MobEffectInstance(ModEffects.TENACITY_BURST,
                    1,
                    1,
                    true,
                    true
            )));

    public static final Holder<Potion> TENACITY_POTION = registerPotion("tenacity_regen",
            new Potion("tenacity_regen", new MobEffectInstance(ModEffects.TENACITY_REGEN,
                    200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_TENACITY_POTION = registerPotion("long_tenacity_regen",
            new Potion("long_tenacity_regen", new MobEffectInstance(ModEffects.TENACITY_REGEN,
                    400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_TENACITY_POTION = registerPotion("strong_tenacity_regen",
            new Potion("strong_tenacity_regen", new MobEffectInstance(ModEffects.TENACITY_REGEN,
                    100,
                    1,
                    true,
                    true
            )));

//=============================================ИСТОЩЕНИЕ ТЕНАСИТИ============================================
    public static final Holder<Potion> TENACITY_DRAIN_POTION = registerPotion("tenacity_drain",
            new Potion("tenacity_drain", new MobEffectInstance(ModEffects.TENACITY_DRAIN,
                    1,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_TENACITY_DRAIN_POTION = registerPotion("strong_tenacity_drain",
            new Potion("strong_tenacity_drain", new MobEffectInstance(ModEffects.TENACITY_DRAIN,
                    1,
                    1,
                    true,
                    true
            )));

    public static final Holder<Potion> TENACITY_ERODE_POTION = registerPotion("tenacity_erode",
            new Potion("tenacity_erode", new MobEffectInstance(ModEffects.TENACITY_ERODE,
                    200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_TENACITY_ERODE_POTION = registerPotion("long_tenacity_erode",
            new Potion("long_tenacity_erode", new MobEffectInstance(ModEffects.TENACITY_ERODE,
                    400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_TENACITY_ERODE_POTION = registerPotion("strong_tenacity_erode",
            new Potion("strong_tenacity_erode", new MobEffectInstance(ModEffects.TENACITY_ERODE,
                    100,
                    1,
                    true,
                    true
            )));

//=================================================ИМУНИТЕТ======================================================
    public static final Holder<Potion> IMMUNITY_POTION = registerPotion("immunity",
            new Potion("immunity", new MobEffectInstance(ModEffects.IMMUNITY,
                    400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_IMMUNITY_POTION = registerPotion("long_immunity",
            new Potion("long_immunity", new MobEffectInstance(ModEffects.IMMUNITY,
                    800,
                    0,
                    true,
                    true
            )));

//=================================================КУРС ПРОКЛЯТИЕ======================================================
    public static final Holder<Potion> CURSE_POTION = registerPotion("curse",
            new Potion("curse", new MobEffectInstance(ModEffects.CURSE,
                    400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_CURSE_POTION = registerPotion("long_curse",
            new Potion("long_curse", new MobEffectInstance(ModEffects.CURSE,
                    800,
                    0,
                    true,
                    true
            )));

//=============================================НЕЛЕТНАЯ ПОГОДА===========================================================
    public static final Holder<Potion> NO_FLY_WEATHER_POTION = registerPotion("no_fly_weather",
            new Potion("no_fly_weather", new MobEffectInstance(ModEffects.NO_FLY_WEATHER,
                    1200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_NO_FLY_WEATHER_POTION = registerPotion("long_no_fly_weather",
            new Potion("long_no_fly_weather", new MobEffectInstance(ModEffects.NO_FLY_WEATHER,
                    2400,
                    0,
                    true,
                    true
            )));

//========================================ДИЗАРМ ОБЕЗОРУЖИВАНИЕ=================================================
    public static final Holder<Potion> DISARM_POTION = registerPotion("disarm",
            new Potion("disarm", new MobEffectInstance(ModEffects.DISARM,
                    160,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_DISARM = registerPotion("long_disarm",
            new Potion("long_disarm", new MobEffectInstance(ModEffects.DISARM,
                    320,
                    0,
                    true,
                    true
            )));

//============================================НОСФЕРАТУ ВАМПИРИЗМ======================================================
    public static final Holder<Potion> NOSFERATU_POTION = registerPotion("nosferatu",
            new Potion("nosferatu", new MobEffectInstance(ModEffects.NOSFERATU,
                    1200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_NOSFERATU_POTION = registerPotion("long_nosferatu",
            new Potion("long_nosferatu", new MobEffectInstance(ModEffects.NOSFERATU,
                    2400,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_NOSFERATU_POTION = registerPotion("strong_nosferatu",
            new Potion("strong_nosferatu", new MobEffectInstance(ModEffects.NOSFERATU,
                    600,
                    1,
                    true,
                    true
            )));

//==========================================ЗАПРЕТ НА ВОЗРОЖДЕНИЕ=================================================
    public static final Holder<Potion> NO_REVIVE_POTION = registerPotion("no_revive",
            new Potion("no_revive", new MobEffectInstance(ModEffects.NO_REVIVE,
                    160,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_NO_REVIVE = registerPotion("long_no_revive",
            new Potion("long_no_revive", new MobEffectInstance(ModEffects.NO_REVIVE,
                    320,
                    0,
                    true,
                    true
            )));

//============================================ГИГАНТ===================================================
    public static final Holder<Potion> GIANT_POTION = registerPotion("giant",
            new Potion("giant", new MobEffectInstance(ModEffects.GIANT,
                    12000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_GIANT_POTION = registerPotion("long_giant",
            new Potion("long_giant", new MobEffectInstance(ModEffects.GIANT,
                    24000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_GIANT_POTION = registerPotion("strong_giant",
            new Potion("strong_giant", new MobEffectInstance(ModEffects.GIANT,
                    6000,
                    1,
                    true,
                    true
            )));

//==========================================ДЮЙМОВОЧКА===================================================
    public static final Holder<Potion> THUMBELINA_POTION = registerPotion("thumbelina",
            new Potion("thumbelina", new MobEffectInstance(ModEffects.THUMBELINA,
                    12000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_THUMBELINA_POTION = registerPotion("long_thumbelina",
            new Potion("long_thumbelina", new MobEffectInstance(ModEffects.THUMBELINA,
                    24000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_THUMBELINA_POTION = registerPotion("strong_thumbelina",
            new Potion("strong_thumbelina", new MobEffectInstance(ModEffects.THUMBELINA,
                    6000,
                    1,
                    true,
                    true
            )));

//=============================================ХРУПКОСТЬ=================================================
    public static final Holder<Potion> FRAGILITY_POTION = registerPotion("fragility",
            new Potion("fragility", new MobEffectInstance(ModEffects.FRAGILITY,
                    600,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_FRAGILITY_POTION = registerPotion("long_fragility",
            new Potion("long_fragility", new MobEffectInstance(ModEffects.FRAGILITY,
                    1200,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_FRAGILITY_POTION = registerPotion("strong_fragility",
            new Potion("strong_fragility", new MobEffectInstance(ModEffects.FRAGILITY,
                    300,
                    1,
                    true,
                    true
            )));

//=============================================ОТРАЖЕНИЕ==================================================
    public static final Holder<Potion> REFLECTION_POTION = registerPotion("reflection",
            new Potion("reflection", new MobEffectInstance(ModEffects.REFLECTION,
                    800,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_REFLECTION_POTION = registerPotion("long_reflection",
            new Potion("long_reflection", new MobEffectInstance(ModEffects.REFLECTION,
                    1600,
                    0,
                    true,
                    true
            )));

//==========================================ГРЕЧЕСКИЙ ОГОНЬ==================================================
    public static final Holder<Potion> GREEK_FIRE_POTION = registerPotion("greek_fire",
            new Potion("greek_fire", new MobEffectInstance(ModEffects.GREEK_FIRE,
                    1000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> LONG_GREEK_FIRE_POTION = registerPotion("long_greek_fire",
            new Potion("long_greek_fire", new MobEffectInstance(ModEffects.GREEK_FIRE,
                    2000,
                    0,
                    true,
                    true
            )));

    public static final Holder<Potion> STRONG_GREEK_FIRE_POTION = registerPotion("strong_greek_fire",
            new Potion("strong_greek_fire", new MobEffectInstance(ModEffects.GREEK_FIRE,
                    500,
                    1,
                    true,
                    true
            )));

//============================================================================================================
//===========================================ИНИЦИАЛИЗАЦИЯ РЕГИСТРАЦИЯ========================================
    private static Holder<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name), potion);
    };

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Potions for " + NOHONOR.MOD_ID);
    }

}
