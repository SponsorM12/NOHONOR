package zver.nohonor.mixin.effect.no_teleport;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Entity.class)
public abstract class EntityNoTeleportPortalMixin {
    //canTeleport(Level, Level) вызывается ИСКЛЮЧИТЕЛЬНО из handlePortal() —
    ///tp и другие пути телепортации сюда не заходят вообще
    @Inject(method = "canTeleport", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockPortalTeleport(Level from, Level to, CallbackInfoReturnable<Boolean> cir) {
        Entity self = (Entity) (Object) this;
        if (self instanceof LivingEntity living && living.hasEffect(ModEffects.NO_TELEPORT)) {
            cir.setReturnValue(false);
        }
    }

}
