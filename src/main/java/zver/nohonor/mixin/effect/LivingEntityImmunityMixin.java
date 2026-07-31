package zver.nohonor.mixin.effect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityImmunityMixin {
    //Логика Иммунитета
    @Inject(method = "canBeAffected", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockHarmfulUnderImmunity(MobEffectInstance instance, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (self.hasEffect(ModEffects.IMMUNITY)
                && instance.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
            cir.setReturnValue(false);
        }
    }
}