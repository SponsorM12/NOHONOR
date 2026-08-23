package zver.nohonor.client.mixin.avatar_layers.custom.hanahaki;

import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.avatar_layers.hanahaki.HanahakiRenderStateAccessor;
import zver.nohonor.custom_mechanics.avatar_layers.hanahaki.HanahakiData;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererMixin {

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void nohonor$extractHanahaki(Avatar entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
        HanahakiRenderStateAccessor accessor = (HanahakiRenderStateAccessor) state;
        if (entity instanceof Player player) {
            accessor.nohonor$setHanahakiVariant(((HanahakiData) player).getHanahakiVariant());
        } else {
            accessor.nohonor$setHanahakiVariant(null);
        }
    }

}