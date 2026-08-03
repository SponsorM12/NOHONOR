package zver.nohonor.effect.custom;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import zver.nohonor.NOHONOR;

public class ThumbelinaEffect extends MobEffect {

    public ThumbelinaEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(Attributes.SCALE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "thumbelina_scale"),
                -0.25D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.MAX_HEALTH,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "thumbelina_health"),
                -0.25D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "thumbelina_entity_range"),
                -0.25D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "thumbelina_block_range"),
                -0.25D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        //ADD_MULTIPLIED_TOTAL - это процент %
        //ADD_MULTIPLIED_BASE - это тупое +-

    }
}