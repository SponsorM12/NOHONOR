package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

import java.util.concurrent.CompletableFuture;

public class ModPaintingsTagsProvider extends FabricTagsProvider<PaintingVariant> {

    public ModPaintingsTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.PAINTING_VARIANT, registryLookupFuture);
    }

    //ТАГИ КАРТИНЫ
    //Если нужно чтобы картина появлялась в пуле перебора картины
    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
                .add(TagEntry.element(ModPaintings.COOL_ECHPOCHMAK.identifier()))
                .add(TagEntry.element(ModPaintings.FIRST_PLANET.identifier()))
                .add(TagEntry.element(ModPaintings.GLADIATOR.identifier()))
                .add(TagEntry.element(ModPaintings.NIAN.identifier()))
                .add(TagEntry.element(ModPaintings.STUDY.identifier()))
                .add(TagEntry.element(ModPaintings.MOUSE.identifier()))
                .add(TagEntry.element(ModPaintings.ANGER.identifier()))
                .add(TagEntry.element(ModPaintings.BASYA.identifier()))
                .add(TagEntry.element(ModPaintings.LUCHI_0.identifier()))
                .add(TagEntry.element(ModPaintings.LUCHI_1.identifier()))
                .add(TagEntry.element(ModPaintings.LUCHI_2.identifier()))
                .add(TagEntry.element(ModPaintings.SHAMAN.identifier()))
                .add(TagEntry.element(ModPaintings.BILLY.identifier()))
                .add(TagEntry.element(ModPaintings.MIRELLE.identifier()))
                .add(TagEntry.element(ModPaintings.LONA.identifier()))
                .add(TagEntry.element(ModPaintings.CHERNOBOG.identifier()))
                .add(TagEntry.element(ModPaintings.ROZMARI.identifier()))
                .add(TagEntry.element(ModPaintings.LUCHI_5.identifier()));
    }
}
