package zver.nohonor.mixin.effect.no_revive;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityNoReviveMixin {
    //Запрет на возрождение
    //Перехватываем триггер Тотема Бессмертия
    @Inject(method = "checkTotemDeathProtection", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockTotemUnderNoRevive(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self.hasEffect(ModEffects.NO_REVIVE)) {
            cir.setReturnValue(false);
        }
    }
}