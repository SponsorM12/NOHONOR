package zver.nohonor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        //root и самое первое стартовое достижение
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        ModItems.BLESSING,
                        Component.translatable("advancement.nohonor.root.title"),
                        Component.translatable("advancement.nohonor.root.description"),
                        Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "/gui/advancements/backgrounds/main"), //почемуто путь с /textures и добовлением .png не работает?
                        AdvancementType.TASK,
                        false, false, false
                )
                .addCriterion("tick",
                        InventoryChangeTrigger.TriggerInstance.hasItems(new net.minecraft.world.level.ItemLike[0])
                )
                .save(consumer, "nohonor:root");

        //Цепочка Материалов:
        AdvancementHolder hellishly_cold = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.RAW_LUMEL,
                        Component.translatable("advancement.nohonor.hellishly_cold.title"),
                        Component.translatable("advancement.nohonor.hellishly_cold.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("has_ore_lumel", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHER_LUMEL_ORE.asItem()))
                .addCriterion("has_raw_lumel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_LUMEL))
                .addCriterion("has_lumel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUMEL_INGOT))
                .requirements(AdvancementRequirements.anyOf(List.of(
                        "has_ore_lumel",
                        "has_raw_lumel",
                        "has_lumel_ingot"
                )))
                .save(consumer, "nohonor:hellishly_cold");

        AdvancementHolder beginning_of_the_ritual = Advancement.Builder.advancement()
                .parent(hellishly_cold)
                .display(
                        ModItems.RAW_SHCHERBARUNE,
                        Component.translatable("advancement.nohonor.beginning_of_the_ritual.title"),
                        Component.translatable("advancement.nohonor.beginning_of_the_ritual.description"),
                        null,
                        AdvancementType.TASK,
                        true, true, false
                )
                .addCriterion("has_ore_shcherbarune", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHER_SHCHERBARUNE_ORE.asItem()))
                .addCriterion("has_raw_shcherbarune", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_SHCHERBARUNE))
                .addCriterion("has_shcherbarune", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SHCHERBARUNE))
                .requirements(AdvancementRequirements.anyOf(List.of(
                        "has_ore_shcherbarune",
                        "has_raw_shcherbarune",
                        "has_shcherbarune"
                )))
                .save(consumer, "nohonor:beginning_of_the_ritual");
    }

    @Override
    public String getName() {
        return "NOHONOR Mod Advancements Provider";
    }
}