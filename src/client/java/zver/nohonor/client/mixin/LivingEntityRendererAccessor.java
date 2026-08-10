package zver.nohonor.client.mixin;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntityRenderer.class)
public interface LivingEntityRendererAccessor {

    //Raw-тип RenderLayer — намеренно, а не забытые дженерики: erasure параметра
    //addLayer(RenderLayer<S, M>) в байткоде — это именно raw RenderLayer,
    //и Invoker матчится по erasure, а не по исходным дженерикам
    @Invoker("addLayer")
    boolean nohonor$addLayer(RenderLayer layer);

}