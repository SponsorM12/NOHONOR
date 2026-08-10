package zver.nohonor.client.mixin.reflection;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.reflection.ReflectionRenderStateAccessor;
import zver.nohonor.effect.ModEffects;

@Mixin(AvatarRenderer.class)
public abstract class PlayerRendererMixin {
    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void injectReflectionState(AbstractClientPlayer player, AvatarRenderState state, float partialTick, CallbackInfo ci) {
        if (state instanceof ReflectionRenderStateAccessor accessor) {
            // Например, если у игрока есть нужный эффект или флаг:
            boolean hasReflection = player.hasEffect(ModEffects.REFLECTION);
            accessor.nohonor$setReflecting(hasReflection);
        }
    }

}
