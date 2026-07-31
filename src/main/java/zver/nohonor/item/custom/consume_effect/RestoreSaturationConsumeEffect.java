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
 * Восстанавливает игроку насыщение (saturation) напрямую, независимо
 * от голода (nutrition). Нужен, потому что FoodProperties.saturationModifier
 * всегда вычисляется как nutrition × saturationModifier — при nutrition = 0
 * никакой модификатор не даст ненулевую сытость.
 */
public record RestoreSaturationConsumeEffect(float saturationAmount) implements ConsumeEffect {

    public static final MapCodec<RestoreSaturationConsumeEffect> CODEC = RecordCodecBuilder.mapCodec((i) -> i.group(
            Codec.FLOAT.fieldOf("saturation_amount").forGetter(RestoreSaturationConsumeEffect::saturationAmount)
    ).apply(i, RestoreSaturationConsumeEffect::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, RestoreSaturationConsumeEffect> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT, RestoreSaturationConsumeEffect::saturationAmount,
            RestoreSaturationConsumeEffect::new
    );

    @Override
    public ConsumeEffect.Type<RestoreSaturationConsumeEffect> getType() {
        return ModConsumeEffectTypes.RESTORE_SATURATION;
    }

    @Override
    public boolean apply(final Level level, final ItemStack stack, final LivingEntity user) {
        if (!(user instanceof Player player)) {
            return false;
        }
        FoodData foodData = player.getFoodData();
        //float newSaturation = Math.min(foodData.getFoodLevel(), foodData.getSaturationLevel() + this.saturationAmount);
        //foodData.setSaturation(newSaturation);
        float newSaturation = foodData.getSaturationLevel() + this.saturationAmount;
        foodData.setSaturation(newSaturation);
        return true;
    }
}