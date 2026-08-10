package zver.nohonor.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import zver.nohonor.NOHONOR;
import zver.nohonor.effect.custom.*;

public class ModEffects extends MobEffects {

    public static final Holder<MobEffect> HANAHAKI = registerMobEffect("hanahaki",
            new HanahakiEffect(MobEffectCategory.NEUTRAL, 0xFFD700)); //GOLD

    public static final Holder<MobEffect> SHATTER = registerMobEffect("shatter",
            new ShatterEffect(MobEffectCategory.HARMFUL, 0x526088)); //Kashmir Blue

    public static final Holder<MobEffect> SCORCH = registerMobEffect("scorch",
            new ScorchEffect(MobEffectCategory.HARMFUL, 0xFF4500));//OrangeRed

    public static final Holder<MobEffect> TENACITY_BURST = registerMobEffect("tenacity_burst",
            new TenacityBurstEffect(MobEffectCategory.BENEFICIAL, 0x06FF06));//Lime

    public static final Holder<MobEffect> TENACITY_REGEN = registerMobEffect("tenacity_regen",
            new TenacityRegenEffect(MobEffectCategory.BENEFICIAL, 0x3BC622));//Lime Green

    public static final Holder<MobEffect> TENACITY_DRAIN = registerMobEffect("tenacity_drain",
            new TenacityDrainEffect(MobEffectCategory.HARMFUL, 0x134D17));//Myrtle.

    public static final Holder<MobEffect> TENACITY_ERODE = registerMobEffect("tenacity_erode",
            new TenacityErodeEffect(MobEffectCategory.HARMFUL, 0x0E3A11));//Myrtle но темнее

    public static final Holder<MobEffect> IMMUNITY = registerMobEffect("immunity",
            new ImmunityEffect(MobEffectCategory.BENEFICIAL, 0x8FEDFC));//Electric Blue

    public static final Holder<MobEffect> CURSE = registerMobEffect("curse",
            new CurseEffect(MobEffectCategory.HARMFUL, 0x393939));//Eclipse

    public static final Holder<MobEffect> NO_FLY_WEATHER = registerMobEffect("no_fly_weather",
            new NonFlyWeatherEffect(MobEffectCategory.HARMFUL, 0xC29A9B));//Careys Pink

    public static final Holder<MobEffect> DISARM = registerMobEffect("disarm",
            new DisarmEffect(MobEffectCategory.HARMFUL, 0x444444));//Charcoal

    public static final Holder<MobEffect> NOSFERATU = registerMobEffect("nosferatu",
            new NosferatuEffect(MobEffectCategory.BENEFICIAL, 0x8F1212));//Falu Red

    public static final Holder<MobEffect> NO_REVIVE = registerMobEffect("no_revive",
            new NoReviveEffect(MobEffectCategory.HARMFUL, 0x1A1A1A));//Nero

    public static final Holder<MobEffect> GIANT = registerMobEffect("giant",
            new GiantEffect(MobEffectCategory.BENEFICIAL, 0x805525));//Hot Curry

    public static final Holder<MobEffect> THUMBELINA = registerMobEffect("thumbelina",
            new ThumbelinaEffect(MobEffectCategory.BENEFICIAL, 0xBB4269));//Royal Heath

    public static final Holder<MobEffect> FRAGILITY = registerMobEffect("fragility",
            new FragilityEffect(MobEffectCategory.HARMFUL, 0xB6B9C0));//Echo Blue

    public static final Holder<MobEffect> REFLECTION = registerMobEffect("reflection",
            new ReflectionEffect(MobEffectCategory.BENEFICIAL, 0xEAFFA2));//Australian Mint

     public static final Holder<MobEffect> GREEK_FIRE = registerMobEffect("greek_fire",
            new GreekFireEffect(MobEffectCategory.HARMFUL, 0xFFFC4F));//Paris Daisy

    private static Holder<MobEffect> registerMobEffect(String name, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name), effect);
    }

    public static void Initialize() {
        NOHONOR.LOGGER.info("Registering Effects for " + NOHONOR.MOD_ID);
    }

}
