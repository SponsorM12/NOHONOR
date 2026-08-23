package zver.nohonor.mixin.effect.no_teleport;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(ThrownEnderpearl.class)
public abstract class ThrownEnderpearlNoTeleportMixin {
    //Ловим владельца жемчуга ДО телепорта, а не общий Entity.teleport(TeleportTransition) —
    //иначе заодно заблокировали бы и порталы, которые пока не трогаем
    @Inject(method = "isAllowedToTeleportOwner", at = @At("HEAD"), cancellable = true)
    private static void nohonor$blockPearlTeleport(Entity owner, Level newLevel, CallbackInfoReturnable<Boolean> cir) {
        if (owner instanceof LivingEntity living && living.hasEffect(ModEffects.NO_TELEPORT)) {
            cir.setReturnValue(false);
        }
    }

}
