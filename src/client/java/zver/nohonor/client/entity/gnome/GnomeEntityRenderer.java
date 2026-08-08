package zver.nohonor.client.entity.gnome;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.client.entity.EntityRenderState;
import zver.nohonor.client.entity.ModEntityModelLayers;
import zver.nohonor.entity.custom.gnome.GnomeEntity;

public class GnomeEntityRenderer extends MobRenderer<GnomeEntity, EntityRenderState, GnomeEntityModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "textures/entity/gnome/gnome.png");

    public GnomeEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new GnomeEntityModel(context.bakeLayer(ModEntityModelLayers.GNOME)), 0.375f); // 0.375 shadow radius
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(EntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public void extractRenderState(GnomeEntity entity, EntityRenderState state, float tickProgress) {
        super.extractRenderState(entity, state, tickProgress);
        state.dancingAnimationState.copyFrom(entity.dancingAnimationState);
    }

}
