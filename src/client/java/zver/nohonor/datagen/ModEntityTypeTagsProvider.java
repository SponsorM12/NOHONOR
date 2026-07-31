package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import zver.nohonor.entity.ModEntityTypes;
import zver.nohonor.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {

    public ModEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
        super(output, providerCompletableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//===================================СЛАБОСТЬ К ЖЕМЧУЖНОМУ СЕРЕБРУ===================================
        tag(ModTags.EntityTypes.WEAK_TO_PEARL_SILVER)
                .addOptionalTag(EntityTypeTags.UNDEAD)
                .add(ModEntityTypes.getRK(EntityTypes.WARDEN));
    }
}