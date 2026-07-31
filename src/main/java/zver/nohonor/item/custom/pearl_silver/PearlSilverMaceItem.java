package zver.nohonor.item.custom.pearl_silver;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.TooltipDisplay;
import zver.nohonor.tag.ModTags;
import zver.nohonor.utilit.TooltipHelper;

import net.minecraft.network.chat.Component;
import java.util.List;
import java.util.function.Consumer;

public class PearlSilverMaceItem extends MaceItem {

    private static final float ATTACK_DAMAGE = 4.0f;   // ванильный mace = 5
    private static final float ATTACK_SPEED  = -3.2f;  // ванильный mace = -3.4

    private static final float DAMAGE_MULTIPLIER = 1.0f;

    public PearlSilverMaceItem(Properties properties) {
        super(properties);
    }

    @Override
    public float getAttackDamageBonus(Entity victim, float baseDamage, DamageSource damageSource) {
        float smashBonus = super.getAttackDamageBonus(victim, baseDamage, damageSource);

        if (victim.typeHolder().is(ModTags.EntityTypes.WEAK_TO_PEARL_SILVER)) {
            return smashBonus + (baseDamage + smashBonus) * DAMAGE_MULTIPLIER;
        }

        return smashBonus;
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, ATTACK_DAMAGE, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, ATTACK_SPEED, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(), 1.0F, 2, false);
    }

    @Override
    public Component getName(ItemStack stack) {
        return TooltipHelper.getColoredName(super.getName(stack), TooltipHelper.LAVENDER);
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            TooltipContext context,
            TooltipDisplay display,
            Consumer<Component> tooltip,
            TooltipFlag flag
    ) {
        super.appendHoverText(stack, context, display, tooltip, flag);
        TooltipHelper.appendLines("item.nohonor.pearl_silver_mace.desc", 1, tooltip);
    }

}