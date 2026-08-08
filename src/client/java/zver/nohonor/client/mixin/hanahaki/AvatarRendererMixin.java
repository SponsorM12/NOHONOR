package zver.nohonor.client.mixin.hanahaki;

import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.hanahaki.HanahakiRenderStateAccessor;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiData;
import zver.nohonor.effect.ModEffects;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererMixin {
    //Переносим synced-данные из живой сущности в render state — именно здесь,
    //а не в самом слое рендера, потому что submit() слоя работает уже без доступа к сущности.
    //Параметр типизирован как Avatar (не AvatarlikeEntity) — это erasure первого баунда
    //дженерика в оригинальном методе, так и матчится мискином.
    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void nohonor$extractHanahaki(Avatar entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
        HanahakiRenderStateAccessor accessor = (HanahakiRenderStateAccessor) state;

        //Avatar сейчас общий для игрока и ClientMannequin — явная проверка типа,
        //а не голое приведение, иначе на манекене поймаем ClassCastException
        if (entity instanceof Player player && player.hasEffect(ModEffects.HANAHAKI)) {
            accessor.nohonor$setHanahakiVariant(((HanahakiData) player).getHanahakiVariant());
        } else {
            accessor.nohonor$setHanahakiVariant(null);
        }
    }
}