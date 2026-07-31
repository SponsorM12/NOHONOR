package zver.nohonor.client;

import net.fabricmc.api.ClientModInitializer;
import zver.nohonor.client.hud.tenacity.ModHudElements;
import zver.nohonor.particle.ModParticleFactories;

public class NOHONORClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		//          |
		//         \|/
		// Эта точка входа подходит для настройки логики, специфичной для клиента, например, для рендеринга.
		ModParticleFactories.initialize();

		ModBoatRenderers.initialize();

		ModFluidRendering.initialize();

		ModHudElements.initialize();

	}
}