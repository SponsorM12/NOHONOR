package zver.nohonor.client.hud.tenacity;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;

public class ModHudElements {

    //СТОЙКОСТЬ
    public static final Identifier TENACITY_BAR =
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "tenacity_bar");

    public static void initialize() {
        //Наследуем от food, ибо он там же и распологается
        HudElementRegistry.attachElementAfter(
                VanillaHudElements.FOOD_BAR,
                TENACITY_BAR,
                new TenacityHudElement()
        );
    }

    private ModHudElements() {}
}
