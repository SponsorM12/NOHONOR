package zver.nohonor.mixin.tenacity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

@Mixin(LivingEntity.class)
public abstract class LivingEntityTenacityMixin {
    //СТОЙКОСТЬ
    //Инжект в метод который отвечает за урон После применения брони и чар
    //То есть Тенасити расчитывается от Конечного урона
    //Тенасити не тратится для снижения урона Первоначального
    @Inject(method = "getDamageAfterMagicAbsorb", at = @At("RETURN"), cancellable = true)
    private void nohonor$reducePlayerDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player) {
            TenacityData tenacityData = (TenacityData) player;
            float maxHp = (float) player.getAttributeValue(Attributes.MAX_HEALTH);
            float reduced = tenacityData.applyTenacityReduction(cir.getReturnValue(), maxHp);
            cir.setReturnValue(reduced);
        }
    }
    //private void nohonor$reducePlayerDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
    //    LivingEntity self = (LivingEntity) (Object) this;
//
    //    //    if (self instanceof Player player) {
    //
    //        float damageAfterMagic = cir.getReturnValue();
//
    //     //        if (damageAfterMagic <= 0.0F) {
    //            return;
    //        }
//
    //        TenacityData tenacityData = (TenacityData) player;
    //        float currentTenacity = tenacityData.getTenacity();
    //        float maxHp = (float) player.getAttributeValue(Attributes.MAX_HEALTH);
//
    //      //        if (maxHp <= 0f || currentTenacity <= 0f) {
    //            return;
    //        }
//
    //     //        float damageFraction = damageAfterMagic / maxHp;
    //        float tenacityToSpend = damageFraction * TenacityData.MAX_TENACITY;
//
    //        tenacityToSpend = Math.min(tenacityToSpend, TenacityData.MAX_TENACITY_SPENT_PER_HIT);
    //        tenacityToSpend = Math.min(tenacityToSpend, currentTenacity);
//
    //        float reduction = tenacityToSpend * TenacityData.DAMAGE_REDUCTION_PER_UNIT;
    //        float reducedDamage = damageAfterMagic * (1f - reduction);
//
    //        tenacityData.setTenacity(currentTenacity - tenacityToSpend);
//
    //        cir.setReturnValue(reducedDamage);
    //    }
    //}
}