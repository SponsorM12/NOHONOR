package zver.nohonor.item.custom.consume_effect;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

/**
 * Кастомный ConsumeEffect: отнимает у игрока голод и/или сытость
 * вместо того, чтобы их восстанавливать. Значения задаются как
 * положительные числа ("сколько отнять"), сама логика вычитания
 * находится внутри apply().
 * <p>
 * Пример регистрации типа — см. ConsumeEffect.Type в декомпиле:
 * добавь статическое поле рядом с остальными Type<...> и
 * зарегистрируй его через Registry.register(BuiltInRegistries.CONSUME_EFFECT_TYPE, ...)
 * в своей инициализации (например, ModConsumeEffects).
 */
public record DrainHungerConsumeEffect(int hungerAmount, float saturationAmount) implements ConsumeEffect {

    public static final MapCodec<DrainHungerConsumeEffect> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(
            Codec.INT.fieldOf("hunger_amount").forGetter(DrainHungerConsumeEffect::hungerAmount),
            Codec.FLOAT.fieldOf("saturation_amount").forGetter(DrainHungerConsumeEffect::saturationAmount)
    ).apply(i, DrainHungerConsumeEffect::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, DrainHungerConsumeEffect> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, DrainHungerConsumeEffect::hungerAmount,
            ByteBufCodecs.FLOAT, DrainHungerConsumeEffect::saturationAmount,
            DrainHungerConsumeEffect::new
    );

    @Override
    public ConsumeEffect.Type<DrainHungerConsumeEffect> getType() {
        return ModConsumeEffectTypes.DRAIN_HUNGER;
    }

    @Override
    public boolean apply(final Level level, final ItemStack stack, final LivingEntity user) {
        if (!(user instanceof Player player)) {
            return false;
        }
        FoodData foodData = player.getFoodData();
        int newFood = Math.max(0, foodData.getFoodLevel() - this.hungerAmount);
        float newSaturation = Math.max(0.0F, foodData.getSaturationLevel() - this.saturationAmount);
        foodData.setFoodLevel(newFood);
        foodData.setSaturation(newSaturation);
        return true;
    }
}
