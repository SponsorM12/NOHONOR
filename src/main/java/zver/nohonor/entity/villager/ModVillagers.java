package zver.nohonor.entity.villager;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Blocks;
import zver.nohonor.NOHONOR;
import zver.nohonor.entity.villager.ModTradeSets;

public class ModVillagers {

    public static final ResourceKey<PoiType> HEAVY_BLACKSMITH_POI_KEY = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE,
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "heavy_blacksmith_poi"));
    public static final PoiType HEAVY_BLACKSMITH_POI = PoiHelper.register(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "heavy_blacksmith_poi"),
            1, 1, Blocks.ANVIL);

    public static final VillagerProfession HEAVY_BLACKSMITH = registerVillagerProfession("heavy_blacksmith", "Heavy Blacksmith", HEAVY_BLACKSMITH_POI_KEY,
            SoundEvents.ANVIL_USE, Int2ObjectMap.ofEntries(
                    Int2ObjectMap.entry(1, ModTradeSets.HEAVY_BLACKSMITH_LEVEL_1),
                    Int2ObjectMap.entry(2, ModTradeSets.HEAVY_BLACKSMITH_LEVEL_2),
                    Int2ObjectMap.entry(3, ModTradeSets.HEAVY_BLACKSMITH_LEVEL_3),
                    Int2ObjectMap.entry(4, ModTradeSets.HEAVY_BLACKSMITH_LEVEL_4),
                    Int2ObjectMap.entry(5, ModTradeSets.HEAVY_BLACKSMITH_LEVEL_5)
            ));


    private static VillagerProfession registerVillagerProfession(String name, String title, ResourceKey<PoiType> poi,
                                                                 SoundEvent sound, Int2ObjectMap<ResourceKey<TradeSet>> map) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name),
                new VillagerProfession(
                        Component.literal(title), holder -> holder.is(poi), holder -> holder.is(poi),
                        ImmutableSet.of(), ImmutableSet.of(), sound, map));
    }

    public static void initialize(){
        NOHONOR.LOGGER.info("Registering ModVillagers for " + NOHONOR.MOD_ID);
    }

}
