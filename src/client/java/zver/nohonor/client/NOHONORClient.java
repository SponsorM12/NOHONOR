package zver.nohonor.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityRenderLayerRegistrationCallback;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import zver.nohonor.client.entity.ModEntityModelLayers;
import zver.nohonor.client.entity.boat.ModBoatRenderer;
import zver.nohonor.client.entity.gnome.GnomeEntityRenderer;
import zver.nohonor.client.avatar_layers.hanahaki.HanahakiModelLayers;
import zver.nohonor.client.avatar_layers.hanahaki.model.HanahakiModel;
import zver.nohonor.client.hud.tenacity.ModHudElements;
import zver.nohonor.client.avatar_layers.reflection.ReflectionArmorLayer;
import zver.nohonor.client.avatar_layers.reflection.ReflectionModelLayers;
import zver.nohonor.client.avatar_layers.reflection.model.ReflectionModel;
import zver.nohonor.entity.ModEntityTypes;
import zver.nohonor.particle.ModParticleFactories;

public class NOHONORClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		//          |
		//         \|/
		// Эта точка входа подходит для настройки логики, специфичной для клиента, например, для рендеринга.
		ModParticleFactories.initialize();

		ModEntityModelLayers.initialize();
		ModBoatRenderer.initialize();
		ModelLayerRegistry.registerModelLayer(HanahakiModelLayers.BASE, HanahakiModel::createBaseLayer);//я не уверен что так должно быть
		ModelLayerRegistry.registerModelLayer(ReflectionModelLayers.SHROUD, ReflectionModel::createBodyLayer);
				EntityRenderers.register(ModEntityTypes.GNOME, GnomeEntityRenderer::new);// 			и здесь я тоже не уверен что верно сделал
		LivingEntityRenderLayerRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
			if (entityRenderer instanceof AvatarRenderer playerRenderer) {
				registrationHelper.register(new ReflectionArmorLayer<>(playerRenderer, context));
			}
		});
		ModFluidRendering.initialize();

		ModHudElements.initialize();

	}

}