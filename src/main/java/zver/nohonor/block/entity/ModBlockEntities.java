package zver.nohonor.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import zver.nohonor.NOHONOR;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.block.entity.custom.ark.ArcCrucibleBlockEntity;
import zver.nohonor.block.entity.custom.pedestal.PedestalBlockEntity;

public class ModBlockEntities {

    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "pedestal_be"),
                    FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build());

    public static final BlockEntityType<ArcCrucibleBlockEntity> ARC_CRUCIBLE_BE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "arc_crucible_be"),
                    FabricBlockEntityTypeBuilder.create(ArcCrucibleBlockEntity::new, ModBlocks.ARC_CRUCIBLE).build());

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering ModBlockEntities for " + NOHONOR.MOD_ID);
    }
}