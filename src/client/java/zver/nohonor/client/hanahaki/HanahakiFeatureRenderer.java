package zver.nohonor.client.hanahaki;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.client.hanahaki.model.HanahakiModel;

public class HanahakiFeatureRenderer extends RenderLayer<AvatarRenderState, PlayerModel> {

    public HanahakiFeatureRenderer(RenderLayerParent<AvatarRenderState, PlayerModel> renderer, EntityRendererProvider.Context context) {
        super(renderer);

        HanahakiModel baseModel = new HanahakiModel(context.bakeLayer(HanahakiModelLayers.BASE));
        Identifier baseTexture = Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "textures/entity/hanahaki/base.png");
        HanahakiRenderVariants.register("base", baseModel, RenderTypes.entitySolid(baseTexture));
        //сюда варианты
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, AvatarRenderState state, float yRot, float xRot) {
        if (state.isInvisible) return;

        String variant = ((HanahakiRenderStateAccessor) state).nohonor$getHanahakiVariant();
        if (variant == null) return; //эффекта нет - ничего не рисуем

        HanahakiRenderVariants.RenderInfo info = HanahakiRenderVariants.get(variant);
        if (info == null) return; //например, старый сейв ссылается на снятый из игры вариант

        submitNodeCollector.submitModel(info.model(), state, poseStack,
                info.renderType(), lightCoords, OverlayTexture.NO_OVERLAY,
                state.outlineColor, (ModelFeatureRenderer.CrumblingOverlay) null);
    }
}