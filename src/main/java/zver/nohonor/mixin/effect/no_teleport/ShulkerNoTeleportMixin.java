package zver.nohonor.mixin.effect.no_teleport;

import net.minecraft.world.entity.monster.Shulker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Shulker.class)
public abstract class ShulkerNoTeleportMixin {
    @Inject(method = "teleportSomewhere", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockShulkerTeleport(CallbackInfoReturnable<Boolean> cir) {
        Shulker self = (Shulker) (Object) this;
        if (self.hasEffect(ModEffects.NO_TELEPORT)) {
            cir.setReturnValue(false);
        }
    }

}
