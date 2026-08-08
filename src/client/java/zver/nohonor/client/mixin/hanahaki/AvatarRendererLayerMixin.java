package zver.nohonor.client.mixin.hanahaki;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.hanahaki.HanahakiFeatureRenderer;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererLayerMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void nohonor$addHanahakiLayer(EntityRendererProvider.Context context, boolean slimSteve, CallbackInfo ci) {
        AvatarRenderer<?> self = (AvatarRenderer<?>) (Object) this;
        //Каст к интерфейсу-аксессору, а не прямой вызов — обходит protected
        //потому что Invoker генерирует вызов напрямую в байткоде, минуя проверку javac
        ((LivingEntityRendererAccessor) self).nohonor$addLayer(new HanahakiFeatureRenderer(self, context));
    }

}