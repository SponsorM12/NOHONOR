package zver.nohonor.mixin.effect.no_fly;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Player.class)
public abstract class PlayerNoFlyGlideMixin {
    //Нелётная погода
    @Inject(method = "canGlide", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockGlideUnderNoFlyWeather(CallbackInfoReturnable<Boolean> cir) {
        Player self = (Player) (Object) this;
        if (self.hasEffect(ModEffects.NO_FLY_WEATHER)) {
            //Закрываем элитры
            //Причем можно прямо во время полёта
            cir.setReturnValue(false);
        }
    }

}