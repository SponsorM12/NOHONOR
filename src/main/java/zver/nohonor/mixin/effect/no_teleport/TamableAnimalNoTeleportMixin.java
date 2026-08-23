package zver.nohonor.mixin.effect.no_teleport;

import net.minecraft.world.entity.TamableAnimal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.effect.ModEffects;

@Mixin(TamableAnimal.class)
public abstract class TamableAnimalNoTeleportMixin {
    //Блокируем на входе, а не глубже в maybeTeleportTo — незачем впустую
    //гонять 10 попыток пасфайндинга ради заведомо отменённого результата
    @Inject(method = "tryToTeleportToOwner", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockPetTeleport(CallbackInfo ci) {
        TamableAnimal self = (TamableAnimal) (Object) this;
        if (self.hasEffect(ModEffects.NO_TELEPORT)) {
            ci.cancel();
        }
    }
}
