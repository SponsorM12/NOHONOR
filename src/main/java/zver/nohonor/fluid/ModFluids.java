package zver.nohonor.fluid;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;

import zver.nohonor.NOHONOR;
import zver.nohonor.fluid.custom.AcidFluid;

public class ModFluids {

    public static final FlowingFluid ACID_STILL = register("acid", new AcidFluid(true));
    public static final FlowingFluid ACID_FLOWING = register("flowing_acid", new AcidFluid(false));

    private static FlowingFluid register(String name, FlowingFluid fluid) {
        ResourceKey<Fluid> key = keyOf(name);
        return Registry.register(BuiltInRegistries.FLUID, key, fluid);
    }

    private static ResourceKey<Fluid> keyOf(String name) {
        return ResourceKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
    }

    //для тегов датагена
    public static ResourceKey<Fluid> getRK(Fluid fluid) {
        return BuiltInRegistries.FLUID.getResourceKey(fluid).get();
    }

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Fluids for " + NOHONOR.MOD_ID);
        }

}