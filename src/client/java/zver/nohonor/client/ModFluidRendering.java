package zver.nohonor.client;


import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;

import net.minecraft.world.level.material.FlowingFluid;

import zver.nohonor.fluid.ModFluids;

public class ModFluidRendering {

    public static void initialize() {
        registerFluidRendering(
                ModFluids.ACID_STILL, ModFluids.ACID_FLOWING,
                Identifier.withDefaultNamespace("block/water_still"),
                Identifier.withDefaultNamespace("block/water_flow"),
                0xB3A715 //Earls Green
        );

        //registerFluidRendering(
        //        ModFluids._STILL, ModFluids._FLOWING,
        //        Identifier.withDefaultNamespace("block/water_still"),
        //        Identifier.withDefaultNamespace("block/water_flow"),
        //        0xFFFFFF
        //);

    }

    private static void registerFluidRendering(FlowingFluid still, FlowingFluid flowing,
                                               Identifier stillTex, Identifier flowTex, int tintArgb) {
        FluidRenderingRegistry.register(still, flowing,
                new FluidModel.Unbaked(
                        new Material(stillTex),
                        new Material(flowTex),
                        new Material(Identifier.withDefaultNamespace("block/water_overlay")),
                        BlockTintSources.constant(ARGB.opaque(tintArgb))
                ));
    }

}