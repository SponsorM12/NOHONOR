package zver.nohonor.client.mixin.avatar_layers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.client.avatar_layers.hanahaki.HanahakiFeatureRenderer;
import zver.nohonor.client.mixin.LivingEntityRendererAccessor;
import zver.nohonor.client.avatar_layers.reflection.ReflectionArmorLayer;

@Mixin(AvatarRenderer.class)
public abstract class AvatarCustomLayersMixin {
    //Единая точка регистрации ВСЕХ кастомных слоёв поверх игрока
    //Раньше у каждого слоя был свой миксин на <init> с одной и той же
    //конструкцией — HanahakiFeatureRenderer и ReflectionArmorLayer
    //доказали дублирование дважды подряд, есть смысл сливать
    @Inject(method = "<init>", at = @At("TAIL"))
    private void nohonor$addCustomLayers(EntityRendererProvider.Context context, boolean slimSteve, CallbackInfo ci) {
        AvatarRenderer<?> self = (AvatarRenderer<?>) (Object) this;
        LivingEntityRendererAccessor accessor = (LivingEntityRendererAccessor) self;

        accessor.nohonor$addLayer(new HanahakiFeatureRenderer(self, context));
        accessor.nohonor$addLayer(new ReflectionArmorLayer<>(self, context));
        //Новый слой — одна строка здесь
    }

}