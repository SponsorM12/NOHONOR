package zver.nohonor.client.mixin.title_screen;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.LogoRenderer;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenRenderMixin extends Screen {

    private static final String EXTRACT = "extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IIF)V";
    private static final Identifier BACKGROUND = Identifier.fromNamespaceAndPath("nohonor", "textures/gui/title/background.png");
    private static final Identifier LOGO       = Identifier.fromNamespaceAndPath("nohonor", "textures/gui/title/logo.png");
    private static final Identifier CORNER     = Identifier.fromNamespaceAndPath("nohonor", "textures/gui/title/corner.png");
    private static final int BACKGROUND_NATIVE_WIDTH = 3840;
    private static final int BACKGROUND_NATIVE_HEIGHT = 1080;
    private static final int LOGO_NATIVE_WIDTH = 1024;
    private static final int LOGO_NATIVE_HEIGHT = 256;

    // конструктор нужен только чтобы extends Screen компилировался; Mixin его вырежет
    protected TitleScreenRenderMixin(Component title) {
        super(title);
    }

    // owner теперь TitleScreen — именно так резолвится этот call site в байткоде
    @Redirect(method = EXTRACT, at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screens/TitleScreen;extractPanorama(Lnet/minecraft/client/gui/GuiGraphicsExtractor;F)V"))
    private void nohonor$background(TitleScreen self, GuiGraphicsExtractor graphics, float a) {
        float scale = Math.max(
                (float) this.width / BACKGROUND_NATIVE_WIDTH,
                (float) this.height / BACKGROUND_NATIVE_HEIGHT
        );
        int drawW = Math.round(BACKGROUND_NATIVE_WIDTH * scale);
        int drawH = Math.round(BACKGROUND_NATIVE_HEIGHT * scale);
        int x = (this.width - drawW) / 2;
        int y = (this.height - drawH) / 2;

        // textureWidth/textureHeight = drawW/drawH (не screen width/height!) — тот же трюк с UV 0..1,
        // но теперь квад имеет пропорции самой картинки, а не пропорции окна
        graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, x, y, 0.0f, 0.0f, drawW, drawH, drawW, drawH);
    }

    @Redirect(method = EXTRACT, at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/components/LogoRenderer;extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IF)V"))
    private void nohonor$logo(LogoRenderer logoRenderer, GuiGraphicsExtractor graphics, int w, float alpha) {
        int targetW = Math.round(this.width * 0.45f);
        int targetH = Math.round(targetW * ((float) LOGO_NATIVE_HEIGHT / LOGO_NATIVE_WIDTH));

// Математически идеальный центр по X
        int centerX = (this.width - targetW) / 2;

// Смещение в пикселях.
// Оставьте 0 для идеального центра.
// Поставьте отрицательное значение (напр. -20), чтобы сдвинуть влево, или положительное, чтобы вправо.
        int offsetX = 0;
        int x = centerX + offsetX;

        int y = Math.round(this.height * 0.07f);

        // 1. Преобразуем float alpha (0.0 - 1.0) в целочисленный альфа-канал (0 - 255)
        // 2. Сдвигаем значение альфы на 24 бита влево (позиция Alpha в ARGB)
        // 3. Объединяем с базовым белым цветом (0x00FFFFFF), чтобы не искажать оригинальные цвета логотипа
        int color = ((int) (alpha * 255.0f) << 24) | 0x00FFFFFF;

        // Передаем переменную color дополнительным (последним) аргументом в метод blit
        graphics.blit(RenderPipelines.GUI_TEXTURED, LOGO, x, y, 0.0f, 0.0f, targetW, targetH, targetW, targetH, color);
    }

    @ModifyVariable(method = EXTRACT, at = @At("STORE"), ordinal = 0)
    private String nohonor$versionText(String original) {
        String version = net.fabricmc.loader.api.FabricLoader.getInstance()
                .getModContainer("nohonor")
                .map(container -> container.getMetadata().getVersion().getFriendlyString())
                .orElse("dev");
        return "NOHONOR v" + version;
    }

    @Inject(method = EXTRACT, at = @At("TAIL"))
    private void nohonor$corners(GuiGraphicsExtractor graphics, int mx, int my, float a, CallbackInfo ci) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, CORNER, 8, 8, 0.0f, 0.0f, 40, 40, 40, 40);
        graphics.blit(RenderPipelines.GUI_TEXTURED, CORNER, this.width - 48, 8, 0.0f, 0.0f, 40, 40, 40, 40);
    }
}