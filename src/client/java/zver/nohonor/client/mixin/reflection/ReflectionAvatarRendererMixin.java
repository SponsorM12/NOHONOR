package zver.nohonor.client.mixin.reflection;

import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.reflection.ReflectionRenderStateAccessor;
import zver.nohonor.effect.ModEffects; // Не забудьте импортировать ваш эффект

@Mixin(AvatarRenderer.class)
public abstract class ReflectionAvatarRendererMixin {

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void nohonor$extractReflection(Avatar entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
        ReflectionRenderStateAccessor accessor = (ReflectionRenderStateAccessor) state;
        if (entity instanceof Player player) {
            // Напрямую проверяем наличие эффекта, без кастомной синхронизации
            accessor.nohonor$setReflecting(player.hasEffect(ModEffects.REFLECTION));
        } else {
            accessor.nohonor$setReflecting(false);
        }
    }

}