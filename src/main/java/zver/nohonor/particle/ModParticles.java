package zver.nohonor.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;

public class ModParticles {

    //ОПАДАЮЩИЕ ЛИСТЬЯ ГЕСПЕРИДЫ
    public static final SimpleParticleType HESPERIDES_LEAF =
            FabricParticleTypes.simple();


    public static void initialize() {
        Registry.register(
                BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hesperides_leaf"),
                HESPERIDES_LEAF //А КАК НОВЫЕ ДОБОВЛЯТЬ?
        );

        NOHONOR.LOGGER.info("Registering Mod Particles for " + NOHONOR.MOD_ID);
    }
}