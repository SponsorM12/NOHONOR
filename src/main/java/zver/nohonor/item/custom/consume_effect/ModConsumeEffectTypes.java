package zver.nohonor.item.custom.consume_effect;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.consume_effects.ConsumeEffect;

public class ModConsumeEffectTypes {

    public static final ConsumeEffect.Type<DrainHungerConsumeEffect> DRAIN_HUNGER = register(
            "drain_hunger",
            DrainHungerConsumeEffect.CODEC,
            DrainHungerConsumeEffect.STREAM_CODEC
    );

    public static final ConsumeEffect.Type<RestoreSaturationConsumeEffect> RESTORE_SATURATION = register(
            "restore_saturation",
            RestoreSaturationConsumeEffect.CODEC,
            RestoreSaturationConsumeEffect.STREAM_CODEC
    );

    private static <T extends ConsumeEffect> ConsumeEffect.Type<T> register(
            String name,
            com.mojang.serialization.MapCodec<T> codec,
            net.minecraft.network.codec.StreamCodec<net.minecraft.network.RegistryFriendlyByteBuf, T> streamCodec
    ) {
        return Registry.register(
                BuiltInRegistries.CONSUME_EFFECT_TYPE,
                name,
                new ConsumeEffect.Type<>(codec, streamCodec)
        );
    }

    // Пустой метод-триггер, чтобы статические поля класса
    // гарантированно инициализировались при загрузке мода
    // (вызови ModConsumeEffectTypes.init() в основном классе мода,
    // как ты, вероятно, уже делаешь для ModBlocks/ModItems/ModStats).
    public static void init() {
    }
}
