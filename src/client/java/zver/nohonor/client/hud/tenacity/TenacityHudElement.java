package zver.nohonor.client.hud.tenacity;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import zver.nohonor.NOHONOR;
import zver.nohonor.custom_mechanics.tenacity.TenacityData;

public class TenacityHudElement implements HudElement {

    private static final Identifier TENACITY_FULL =
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hud/tenacity_full");
    private static final Identifier TENACITY_HALF =
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hud/tenacity_half");
    private static final Identifier TENACITY_EMPTY =
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "hud/tenacity_empty");

    private static final int ICON_SIZE = 9;   //стандарт
    private static final int ICON_STEP = 8;   //шаг
    private static final int ICON_COUNT = 10; //10 иконок

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) {
            return;
        }

        TenacityData tenacityData = (TenacityData) player;
        float tenacity = tenacityData.getTenacity();

        int screenWidth  = graphics.guiWidth();
        int screenHeight = graphics.guiHeight();

        //
        //Расчет координат идет от центра экрана
        //Те же координаты что у food:
        int xRight = screenWidth / 2 + 91;
        int y = screenHeight - 39;

        for (int i = 0; i < ICON_COUNT; i++) {
            //Не понял математику здесь
            //i=0 — крайняя правая иконка (покрывает единицы 19-20)
            //i=9 — крайняя левая  иконка (покрывает единицы  1-2)
            float iconMax = (float)(ICON_COUNT - i) * 2f;  //20, 18, 16, ... 2
            float iconMin = iconMax - 2f;                   //18, 16, 14, ... 0

            int xo = xRight - i * ICON_STEP - ICON_SIZE;

            if (tenacity >= iconMax) {
                //Полная иконка
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, TENACITY_FULL, xo, y, ICON_SIZE, ICON_SIZE);
            } else if (tenacity > iconMin) {
                //Половинная иконка
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, TENACITY_HALF, xo, y, ICON_SIZE, ICON_SIZE);
            } else {
                //Пустая иконка
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, TENACITY_EMPTY, xo, y, ICON_SIZE, ICON_SIZE);
            }
        }
    }
}
