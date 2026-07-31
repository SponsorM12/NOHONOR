package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import zver.nohonor.fluid.ModFluid;
import zver.nohonor.fluid.ModFluids;
import zver.nohonor.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidsTagsProvider extends FabricTagsProvider.FluidTagsProvider {

    public ModFluidsTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
        super(output, providerCompletableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//==========================================ЖИДКОСТИ================================================
        tag(ModTags.Fluids.ACID)
                .add(ModFluids.getRK(ModFluids.ACID_STILL))
                .add(ModFluids.getRK(ModFluids.ACID_FLOWING));

        tag(FluidTags.SUPPORTS_LILY_PAD)
                .add(ModFluids.getRK(ModFluids.ACID_STILL))
                .add(ModFluids.getRK(ModFluids.ACID_FLOWING));

        //tag(ModTags.Fluids.SWIMMABLE)
       //         .add(ModFluids.getRK(ModFluids.ACID_STILL))
       //         .add(ModFluids.getRK(ModFluids.ACID_FLOWING));

        //tag(FluidTags.WATER)
        //       .add(ModFluids.getRK(ModFluids.ACID_STILL))
        //        .add(ModFluids.getRK(ModFluids.ACID_FLOWING));
    }

    // SUPPORTS_SUGAR_CANE_ADJACENTLY = create("supports_sugar_cane_adjacently");
    //SUPPORTS_LILY_PAD = create("supports_lily_pad");
    //SUPPORTS_FROGSPAWN = create("supports_frogspawn");
    // BUBBLE_COLUMN_CAN_OCCUPY = create("bubble_column_can_occupy");

}