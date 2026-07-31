package zver.nohonor.mixin.armor.silver_pearl;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.tag.ModTags;


@Mixin(LivingEntity.class)
public abstract class LivingEntityPearlSilverArmorMixin {
    //Снижаение урона при надетой броне Серебра
    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
    };
    private static final float REDUCTION_PER_PIECE = 0.125f;

    @Inject(method = "getDamageAfterArmorAbsorb", at = @At("RETURN"), cancellable = true)
    private void nohonor$reducePearlSilverDamage(DamageSource source, float damage, CallbackInfoReturnable<Float> cir) {
        Entity attacker = source.getEntity();
        if (attacker == null || !attacker.typeHolder().is(ModTags.EntityTypes.WEAK_TO_PEARL_SILVER)) {
            return;
        }

        LivingEntity target = (LivingEntity) (Object) this;
        int pieces = 0;
        for (EquipmentSlot slot : ARMOR_SLOTS) {
            if (target.getItemBySlot(slot).is(ModTags.Items.PEARL_SILVER_ARMOR)) {
                pieces++;
            }
        }

        if (pieces > 0) {
            float multiplier = Math.max(0f, 1.0f - REDUCTION_PER_PIECE * pieces);
            cir.setReturnValue(cir.getReturnValue() * multiplier);
        }
    }
}