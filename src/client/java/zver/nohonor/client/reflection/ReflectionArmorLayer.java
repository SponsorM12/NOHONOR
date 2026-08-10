package zver.nohonor.client.reflection;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import zver.nohonor.client.reflection.model.ReflectionModel;

// 1. Делаем слой обобщенным относительно модели родителя (M)
public class ReflectionArmorLayer<M extends EntityModel<AvatarRenderState>> extends EnergySwirlLayer<AvatarRenderState, M> {
    private static final Identifier WITHER_ARMOR = Identifier.withDefaultNamespace("textures/entity/wither/wither_armor.png");
    private final ReflectionModel model;

    // 2. Заменяем ReflectionModel на M в аргументе конструктора
    public ReflectionArmorLayer(RenderLayerParent<AvatarRenderState, M> renderer, EntityRendererProvider.Context context) {
        super(renderer);
        this.model = new ReflectionModel(context.bakeLayer(ReflectionModelLayers.SHROUD));
    }

    @Override protected boolean isPowered(AvatarRenderState state) {
        return ((ReflectionRenderStateAccessor) state).nohonor$isReflecting();
    }

    @Override protected float xOffset(float t) { return Mth.cos((double)(t * 0.02F)) * 3.0F; }

    @Override protected Identifier getTextureLocation() { return WITHER_ARMOR; }

    // 3. Возвращаем нашу модель, кастуя её к M.
    // На рантайме EnergySwirlLayer ожидает просто EntityModel<AvatarRenderState>, поэтому ClassCastException не будет.
    @SuppressWarnings("unchecked")
    @Override protected M model() {
        return (M) this.model;
    }

}