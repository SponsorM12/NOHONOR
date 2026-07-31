package zver.nohonor.item.custom.pearl_silver;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import zver.nohonor.tag.ModTags;
import zver.nohonor.utilit.TooltipHelper;

import java.util.function.Consumer;

public class PearlSilverSwordItem extends Item {

    private static final float BONUS_MULTIPLIER = 1.25f;

    public PearlSilverSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public float getAttackDamageBonus(Entity victim, float baseDamage, DamageSource damageSource) {
        if (victim.typeHolder().is(ModTags.EntityTypes.WEAK_TO_PEARL_SILVER)) {
            return baseDamage * BONUS_MULTIPLIER;
        }
        return 0.0F;
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
        TooltipHelper.appendLines("item.nohonor.pearl_silver_sword.desc", 1, tooltip);
    }
}