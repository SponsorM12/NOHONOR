package zver.nohonor.effect.custom;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import zver.nohonor.NOHONOR;

public class FragilityEffect extends MobEffect {

    public FragilityEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "fragility_fall_damage"),
                1.0D, AttributeModifier.Operation.ADD_VALUE); //+100%
        //я забыл, почему мы используем Double а не F?
        this.addAttributeModifier(Attributes.SAFE_FALL_DISTANCE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "fragility_safe_fall"),
                -1.0D, AttributeModifier.Operation.ADD_VALUE);
    }
}