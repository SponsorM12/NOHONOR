package zver.nohonor.effect.custom;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import zver.nohonor.NOHONOR;

public class GiantEffect extends MobEffect {

    public GiantEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(Attributes.SCALE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "giant_scale"),
                0.25D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.MAX_HEALTH,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "giant_health"),
                0.1D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "giant_entity_range"),
                0.125D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
        this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "giant_block_range"),
                0.125D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);

        //this.addAttributeModifier(Attributes.JUMP_STRENGTH,
        //        Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "giant_jump"),
        //        0.5D, AttributeModifier.Operation.ADD_VALUE);

    }
}