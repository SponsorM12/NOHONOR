package zver.nohonor.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import zver.nohonor.NOHONOR;
import zver.nohonor.effect.ModEffects;

public class ModPotions {

//=================================================ИССУШЕНИЕ============================================
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

    private static Holder<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name), potion);
    };

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Potions for " + NOHONOR.MOD_ID);
    }

}
