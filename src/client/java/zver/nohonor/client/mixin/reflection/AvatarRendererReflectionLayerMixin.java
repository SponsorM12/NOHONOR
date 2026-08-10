package zver.nohonor.client.mixin.reflection;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.mixin.LivingEntityRendererAccessor;
import zver.nohonor.client.reflection.ReflectionArmorLayer;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererReflectionLayerMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void nohonor$addReflectionLayer(EntityRendererProvider.Context context, boolean slimSteve, CallbackInfo ci) {
        AvatarRenderer<?> self = (AvatarRenderer<?>) (Object) this;
        // Добавлен <> в new ReflectionArmorLayer<>(...)
        ((LivingEntityRendererAccessor) self).nohonor$addLayer(new ReflectionArmorLayer<>(self, context));
    }

}