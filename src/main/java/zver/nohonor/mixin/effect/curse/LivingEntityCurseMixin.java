package zver.nohonor.mixin.effect.curse;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityCurseMixin {
    //Логика Проклятия
    @Inject(method = "canBeAffected", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockHarmfulUnderCurse(MobEffectInstance instance, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        //Непосредственно блокирвем любые Положительные эффекты
        if (self.hasEffect(ModEffects.CURSE)
                && instance.getEffect().value().getCategory() == MobEffectCategory.BENEFICIAL) {
            cir.setReturnValue(false);
        }
    }
}