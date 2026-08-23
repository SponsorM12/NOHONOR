package zver.nohonor.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import zver.nohonor.NOHONOR;
import zver.nohonor.entity.custom.RisingBlockEntity;
import zver.nohonor.entity.custom.gnome.GnomeEntity;

public class ModEntityTypes {

    public static ResourceKey<EntityType<?>> getRK(EntityType<?> entityType) {
        return BuiltInRegistries.ENTITY_TYPE.getResourceKey(entityType).get();

    }

    public static final EntityType<RisingBlockEntity> RISING_BLOCK = register(
            "rising_block",
            EntityType.Builder.<RisingBlockEntity>of(RisingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98f, 0.98f));

    public static final EntityType<GnomeEntity> GNOME = register(
            "gnome",
            EntityType.Builder.<GnomeEntity>of(GnomeEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.75f));

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerModEntityTypes() {
        NOHONOR.LOGGER.info("Registering EntityTypes for " + NOHONOR.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(GNOME, GnomeEntity.createCubeAttributes());
    }

}