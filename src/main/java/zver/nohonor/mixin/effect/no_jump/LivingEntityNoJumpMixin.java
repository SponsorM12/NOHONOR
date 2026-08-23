package zver.nohonor.mixin.effect.no_jump;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.effect.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityNoJumpMixin {
    //jumpFromGround() в Player не переопределён — используется реализация
    //LivingEntity как есть, значит один перехват закрывает и игрока, и мобов
    @Inject(method = "jumpFromGround", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockJump(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self.hasEffect(ModEffects.NO_JUMP)) {
            ci.cancel();
        }
    }

}
