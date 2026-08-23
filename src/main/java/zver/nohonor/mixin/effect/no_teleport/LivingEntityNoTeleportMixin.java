package zver.nohonor.mixin.effect.no_teleport;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityNoTeleportMixin {
    //Общая точка: Хорус, само-телепорт и телепорт-к-цели Эндермена — все
    //сводятся сюда. cir.setReturnValue(false) — это уже штатный, ожидаемый
    //исход метода (каждый вызывающий код и так обрабатывает "не получилось")
    @Inject(method = "randomTeleport", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockRandomTeleport(double x, double y, double z, boolean showParticles, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self.hasEffect(ModEffects.NO_TELEPORT)) {
            cir.setReturnValue(false);
        }
    }

}
