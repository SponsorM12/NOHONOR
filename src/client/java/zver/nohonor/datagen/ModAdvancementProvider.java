package zver.nohonor.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new NOHONORModAdvancements()));
    }

    public static class NOHONORModAdvancements implements AdvancementSubProvider {

        @Override
        public void generate(HolderLookup.Provider registering, Consumer<AdvancementHolder> output) {

            var Items = registering.lookupOrThrow(Registries.ITEM);
            var Blocks = registering.lookupOrThrow(Registries.BLOCK);

            //root и самое первое стартовое достижение
            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModItems.BLESSING,
                            Component.translatable("advancement.nohonor.root.title"),
                            Component.translatable("advancement.nohonor.root.description"),
                            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "gui/advancements/backgrounds/main"),
                            AdvancementType.TASK,
                            false, false, false
                    )
                    .addCriterion("tick",
                            InventoryChangeTrigger.TriggerInstance.hasItems(new net.minecraft.world.level.ItemLike[0])
                    )
                    .save(output, NOHONOR.MOD_ID + "nohonor:root");

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
                    .save(output, NOHONOR.MOD_ID + "nohonor:hellishly_cold");

            AdvancementHolder the_power_of_a_sorcerer_in_a_crystal = Advancement.Builder.advancement()
                    .parent(hellishly_cold)
                    .display(
                            ModItems.RAW_SHCHERBARUNE,
                            Component.translatable("advancement.nohonor.the_power_of_a_sorcerer_in_a_crystal.title"),
                            Component.translatable("advancement.nohonor.the_power_of_a_sorcerer_in_a_crystal.description"),
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
                    .save(output, NOHONOR.MOD_ID + "nohonor:the_power_of_a_sorcerer_in_a_crystal");

            AdvancementHolder the_real_beginning = Advancement.Builder.advancement()
                    .parent(the_power_of_a_sorcerer_in_a_crystal)
                    .display(
                            ModItems.RAW_BISMUTH,
                            Component.translatable("advancement.nohonor.the_real_beginning.title"),
                            Component.translatable("advancement.nohonor.the_real_beginning.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, false
                    )
                    .addCriterion("has_ore_bismuth", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.END_STONE_BISMUTH_ORE.asItem()))
                    .addCriterion("has_raw_bismuth", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_BISMUTH))
                    .addCriterion("has_bismuth", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BISMUTH))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_ore_bismuth",
                            "has_raw_bismuth",
                            "has_bismuth"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:the_real_beginning");

            AdvancementHolder new_shiny_things = Advancement.Builder.advancement()
                    .parent(the_real_beginning)
                    .display(
                            ModBlocks.DEEPSLATE_GALENA_ORE,
                            Component.translatable("advancement.nohonor.new_shiny_things.title"),
                            Component.translatable("advancement.nohonor.new_shiny_things.description"),
                            null,
                            AdvancementType.TASK,
                            false, true, false
                    )
                    .addCriterion("has_raw_gliniy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_GLINIY))
                    .addCriterion("has_gliniy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GLINIY_INGOT))
                    .addCriterion("has_raw_chromium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_CHROMIUM))
                    .addCriterion("has_chromium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHROMIUM_INGOT))
                    .addCriterion("has_raw_lyutyy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_LYUTYY))
                    .addCriterion("has_lyutyy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LUMEL_INGOT))
                    .addCriterion("has_raw_plymblum", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_PLYMBLUM))
                    .addCriterion("has_plymblum_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLYMBLUM_INGOT))
                    .addCriterion("has_raw_pearl_silver", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_PEARL_SILVER))
                    .addCriterion("has_pearl_silver_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PEARL_SILVER_INGOT))
                    .addCriterion("has_raw_titanium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_TITANIUM))
                    .addCriterion("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TITANIUM_INGOT))
                    .addCriterion("has_raw_zubets", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_ZUBETS))
                    .addCriterion("has_zubets_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ZUBETS_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_gliniy",
                            "has_gliniy_ingot",
                            "has_raw_chromium",
                            "has_chromium_ingot",
                            "has_raw_lyutyy",
                            "has_lyutyy_ingot",
                            "has_raw_plymblum",
                            "has_plymblum_ingot",
                            "has_raw_pearl_silver",
                            "has_pearl_silver_ingot",
                            "has_raw_titanium",
                            "has_titanium_ingot",
                            "has_raw_zubets",
                            "has_zubets_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:new_shiny_things");

            AdvancementHolder almost_free = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.GLINIY_INGOT,
                            Component.translatable("advancement.nohonor.almost_free.title"),
                            Component.translatable("advancement.nohonor.almost_free.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_gliniy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_GLINIY))
                    .addCriterion("has_gliniy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.GLINIY_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_gliniy",
                            "has_gliniy_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:almost_free");

            AdvancementHolder immutability = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.CHROMIUM_INGOT,
                            Component.translatable("advancement.nohonor.immutability.title"),
                            Component.translatable("advancement.nohonor.immutability.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_chromium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_CHROMIUM))
                    .addCriterion("has_chromium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHROMIUM_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_chromium",
                            "has_chromium_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:immutability");

            AdvancementHolder with_a_bang = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.LYUTYY_INGOT,
                            Component.translatable("advancement.nohonor.with_a_bang.title"),
                            Component.translatable("advancement.nohonor.with_a_bang.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_lyutyy", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_LYUTYY))
                    .addCriterion("has_lyutyy_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.LYUTYY_INGOT)) // Исправлена опечатка из new_shiny_things (там был LUMEL_INGOT)
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_lyutyy",
                            "has_lyutyy_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:with_a_bang");

            AdvancementHolder even_superman_wont_see_through = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.PLYMBLUM_INGOT,
                            Component.translatable("advancement.nohonor.even_superman_wont_see_through.title"),
                            Component.translatable("advancement.nohonor.even_superman_wont_see_through.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_plymblum", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_PLYMBLUM))
                    .addCriterion("has_plymblum_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLYMBLUM_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_plymblum",
                            "has_plymblum_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:even_superman_wont_see_through");

            AdvancementHolder magic_sand = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.PEARL_SILVER_INGOT,
                            Component.translatable("advancement.nohonor.magic_sand.title"),
                            Component.translatable("advancement.nohonor.magic_sand.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_pearl_silver", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_PEARL_SILVER))
                    .addCriterion("has_pearl_silver_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PEARL_SILVER_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_pearl_silver",
                            "has_pearl_silver_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:magic_sand");

            AdvancementHolder toothpaste = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.TITANIUM_INGOT,
                            Component.translatable("advancement.nohonor.toothpaste.title"),
                            Component.translatable("advancement.nohonor.toothpaste.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_titanium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_TITANIUM))
                    .addCriterion("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TITANIUM_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_titanium",
                            "has_titanium_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:toothpaste");

            AdvancementHolder galvanized_metall = Advancement.Builder.advancement()
                    .parent(new_shiny_things)
                    .display(
                            ModItems.ZUBETS_INGOT,
                            Component.translatable("advancement.nohonor.galvanized_metall.title"),
                            Component.translatable("advancement.nohonor.galvanized_metall.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, true
                    )
                    .addCriterion("has_raw_zubets", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_ZUBETS))
                    .addCriterion("has_zubets_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ZUBETS_INGOT))
                    .requirements(AdvancementRequirements.anyOf(List.of(
                            "has_raw_zubets",
                            "has_zubets_ingot"
                    )))
                    .save(output, NOHONOR.MOD_ID + "nohonor:galvanized_metall");

        }

    }

    @Override
    public String getName() {
        return "NOHONOR Mod Advancements Provider";
    }

}