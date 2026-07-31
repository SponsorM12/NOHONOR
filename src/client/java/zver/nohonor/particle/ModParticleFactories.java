package zver.nohonor.particle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.particle.ParticleProvider;

public class ModParticleFactories {
    public static void initialize() {

        ParticleProviderRegistry.getInstance().register(
                ModParticles.HESPERIDES_LEAF,
                FallingLeavesParticle.PaleOakProvider::new //<-----свой провайдер надо сделаТЬ!!!!!!!!!!

        );
    }
}