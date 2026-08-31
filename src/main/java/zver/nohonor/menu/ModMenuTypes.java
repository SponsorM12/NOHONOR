package zver.nohonor.menu;

import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.MenuType;
import zver.nohonor.NOHONOR;
import zver.nohonor.menu.custom.arc_crucible.ArcCrucibleMenu;

public class ModMenuTypes {

    public static final MenuType<ArcCrucibleMenu> ARC_CRUCIBLE_MENU =
            Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "arc_crucible_menu"),
                    new ExtendedMenuType<>(ArcCrucibleMenu::new, BlockPos.STREAM_CODEC));

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering ModMenuTypes for " + NOHONOR.MOD_ID);
    }

}