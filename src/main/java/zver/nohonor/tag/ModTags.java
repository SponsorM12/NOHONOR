package zver.nohonor.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import zver.nohonor.NOHONOR;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_PEARL_SILVER_TOOL = createTag("needs_pearl_silver_tool");
        public static final TagKey<Block> INCORRECT_FOR_PEARL_SILVER_TOOL = createTag("incorrect_for_pearl_silver_tool");

        public static final TagKey<Block> PYRITE_ORES = createTag("pyrite_ores");
        public static final TagKey<Block> GALENA_ORES = createTag("galena_ores");
        public static final TagKey<Block> BAUXITE_ORES = createTag("bauxite_ores");
        public static final TagKey<Block> SPODUMENE_ORES = createTag("spodumene_ores");
        public static final TagKey<Block> LUMEL_ORES = createTag("lumel_ores");
        public static final TagKey<Block> SHCHERBARUNE_ORES = createTag("shcherbarune_ores");
        public static final TagKey<Block> BISMUTH_ORES = createTag("bismuth_ores");

        public static final TagKey<Block> HESPERIDES_LOGS = createTag("hesperides_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
        };
    }

    public static class Items {

        public static final TagKey<Item> ABBOT = createTag("abbot");

        public static final TagKey<Item> PROTOCOLS = createTag("protocols");

        public static final TagKey<Item> PEARL_SILVER_REPAIR = createTag("pearl_silver_repair");
        public static final TagKey<Item> PEARL_SILVER_ARMOR = createTag("pearl_silver_armor");

        public static final TagKey<Item> FANTASTIC_INGOTS = createTag("fantastic_ingots");
        public static final TagKey<Item> PYRITE_ORES = createTag("pyrite_ores");
        public static final TagKey<Item> GALENA_ORES = createTag("galena_ores");
        public static final TagKey<Item> BAUXITE_ORES = createTag("bauxite_ores");
        public static final TagKey<Item> SPODUMENE_ORES = createTag("spodumene_ores");
        public static final TagKey<Item> LUMEL_ORES = createTag("lumel_ores");
        public static final TagKey<Item> SHCHERBARUNE_ORES = createTag("shcherbarune_ores");
        public static final TagKey<Item> BISMUTH_ORES = createTag("bismuth_ores");

        public static final TagKey<Item> HESPERIDES_LOGS = createTag("hesperides_logs");

        public static final TagKey<Item> TENACITY_FOOD = createTag("tenacity_food");



                private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
        }
    }

    public static class Fluids {

        public static final TagKey<Fluid> ACID = createTag("acid");

        private static TagKey<Fluid> createTag(String name) {
            return TagKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
        }

        //public static final TagKey<Fluid> SWIMMABLE = TagKey.create(Registries.FLUID,
        //        Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "swimmable"));

    }

    public static class EntityTypes {

        public static final TagKey<EntityType<?>> WEAK_TO_PEARL_SILVER = createTag("weak_to_pearl_silver");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
        };
    }

    public static class Trades {

        public static final TagKey<VillagerTrade> HEAVY_BLACKSMITH_LEVEL_1 = createTag("heavy_blacksmith/level_1");
        public static final TagKey<VillagerTrade> HEAVY_BLACKSMITH_LEVEL_2 = createTag("heavy_blacksmith/level_2");
        public static final TagKey<VillagerTrade> HEAVY_BLACKSMITH_LEVEL_3 = createTag("heavy_blacksmith/level_3");
        public static final TagKey<VillagerTrade> HEAVY_BLACKSMITH_LEVEL_4 = createTag("heavy_blacksmith/level_4");
        public static final TagKey<VillagerTrade> HEAVY_BLACKSMITH_LEVEL_5 = createTag("heavy_blacksmith/level_5");

        private static TagKey<VillagerTrade> createTag(String name) {
            return TagKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
        }
    }

}

