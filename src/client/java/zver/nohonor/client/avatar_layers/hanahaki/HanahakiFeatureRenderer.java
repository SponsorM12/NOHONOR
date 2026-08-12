package zver.nohonor.client.avatar_layers.hanahaki;

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
import zver.nohonor.client.avatar_layers.hanahaki.model.HanahakiModel;
import zver.nohonor.custom_mechanics.hanahaki.HanahakiVariants;

public class HanahakiFeatureRenderer extends RenderLayer<AvatarRenderState, PlayerModel> {

    public HanahakiFeatureRenderer(RenderLayerParent<AvatarRenderState, PlayerModel> renderer, EntityRendererProvider.Context context) {
        super(renderer);

        HanahakiModel baseModel = new HanahakiModel(context.bakeLayer(HanahakiModelLayers.BASE));

        //сюда варианты
        registerBaseVariant(HanahakiVariants.BASE_0, "base_0.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_1, "base_1.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_2, "base_2.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_3, "base_3.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_4, "base_4.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_5, "base_5.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_6, "base_6.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_7, "base_7.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_8, "base_8.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_9, "base_9.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_10, "base_10.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_11, "base_11.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_12, "base_12.png", baseModel);
        registerBaseVariant(HanahakiVariants.BASE_13, "base_13.png", baseModel);
    }

    private static void registerBaseVariant(String id, String fileName, HanahakiModel model) {
        Identifier texture = Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "textures/entity/hanahaki/" + fileName);
        HanahakiRenderVariants.register(id, model, RenderTypes.entityCutout(texture));
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