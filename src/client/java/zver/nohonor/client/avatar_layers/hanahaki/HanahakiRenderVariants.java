package zver.nohonor.client.avatar_layers.hanahaki;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

//Клиентская таблица "id варианта -> как рисовать". Полностью отдельна от common-реестра
//HanahakiVariants — тот выбирает id, ничего не зная про рендер; эта таблица не знает про рандом.
//RenderType, а не голая текстура — чтобы каждый вариант сам решал solid он или cutout
//(будущие плоские лепестки могут захотеть cutout, наш "шлем" — solid, как броня/плащ).
public class HanahakiRenderVariants {

    public record RenderInfo(HumanoidModel<AvatarRenderState> model, RenderType renderType) {}

    private static final Map<String, RenderInfo> VARIANTS = new HashMap<>();

    public static void register(String id, HumanoidModel<AvatarRenderState> model, RenderType renderType) {
        VARIANTS.put(id, new RenderInfo(model, renderType));
    }

    public static @Nullable RenderInfo get(String id) {
        return VARIANTS.get(id);
    }

    private HanahakiRenderVariants() {}

}