package zver.nohonor.entity.boat;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import zver.nohonor.NOHONOR;
import zver.nohonor.item.ModItems;

public class ModBoats {

    // Лямбда () -> ModItems.HESPERIDES_BOAT безопасно откладывает получение предмета до момента, когда он уже точно существует
    public static final EntityType<Boat> HESPERIDES_BOAT = registerBoatEntity("hesperides_boat",
            (type, level) -> new Boat(type, level, () -> ModItems.HESPERIDES_BOAT));

    public static final EntityType<ChestBoat> HESPERIDES_CHEST_BOAT = registerBoatEntity("hesperides_chest_boat",
            (type, level) -> new ChestBoat(type, level, () -> ModItems.HESPERIDES_CHEST_BOAT));

    // ─── Helpers ─────────────────────────────────────────────────────────────

    private static <T extends AbstractBoat> EntityType<T> registerBoatEntity(String name, EntityType.EntityFactory<T> factory) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(
                Registries.ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name)
        );
        return Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                key,
                EntityType.Builder.of(factory, MobCategory.MISC)
                        .noLootTable()
                        .sized(1.375F, 0.5625F)
                        .eyeHeight(0.5625F)
                        .clientTrackingRange(10)
                        .build(key)
        );
    }

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Mod Boats for " + NOHONOR.MOD_ID);
    }
}