package zver.nohonor.client.mixin.title_screen;

import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import net.minecraft.client.gui.components.CommonButtons;
import net.minecraft.client.gui.components.FriendsButton;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.SpriteIconButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.friends.FriendsOverlayScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import net.minecraft.client.gui.screens.options.AccessibilityOptionsScreen;
import net.minecraft.client.gui.screens.options.LanguageSelectScreen;
import net.minecraft.client.gui.screens.options.OnlineOptionsScreen;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenLayoutMixin extends Screen {

    @Shadow
    private @Nullable FriendsButton friends;
    @Shadow private @Nullable RealmsNotificationsScreen realmsNotificationsScreen;

    private TitleScreenLayoutMixin(Component title) { super(title); }

    @Inject(method = "init()V", at = @At("HEAD"), cancellable = true)
    private void nohonor$layout(CallbackInfo ci) {
        //left - отступ ВСЕГО меню от левого края экрана
        //0.16f = 16% ширины окна. Больше -> меню правее, меньше -> ближе к краю
        //Эта же цифра используется в TitleScreenRenderMixin для позиции лого - если меняешь тут, меняй и там.
        int left = (int) (this.width * 0.187f);

        // lineGap - вертикальное расстояние МЕЖДУ соседними пунктами меню (Singleplayer/Multiplayer/Realms).
        // 0.065f = 6.5% высоты окна на один шаг. Больше -> кнопки дальше друг от друга по вертикали
        float lineGap = this.height * 0.08f;

        // topPos - стартовая Y-позиция первой кнопки (Singleplayer).
        // 0.40f = 40% высоты окна от верха. Больше -> весь блок кнопок ниже, меньше -> выше
        float topPos = this.height * 0.35f;

        this.addRenderableWidget(new PlainTextButton(left, (int) topPos, 160, 16,
                Component.translatable("menu.singleplayer"),
                b -> this.minecraft.gui.setScreen(new SelectWorldScreen(this)), this.font));
        topPos += lineGap; // шаг вниз к следующей кнопке - регулируется через lineGap выше

        Screen mpScreen = this.minecraft.options.skipMultiplayerWarning
                ? new JoinMultiplayerScreen(this) : new SafetyScreen(this);
        this.addRenderableWidget(new PlainTextButton(left, (int) topPos, 160, 16,
                Component.translatable("menu.multiplayer"), b -> this.minecraft.gui.setScreen(mpScreen), this.font));
        topPos += lineGap;

        this.addRenderableWidget(new PlainTextButton(left, (int) topPos, 160, 16,
                Component.translatable("menu.online"),
                b -> this.minecraft.gui.setScreen(new RealmsMainScreen(this)), this.font));
        topPos += lineGap;

        // Проверяем, загружен ли мод ModMenu
        if (net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("modmenu")) {
            // Добавляем текстовую кнопку модов, если мод есть
            this.addRenderableWidget(new PlainTextButton(left, (int) topPos, 160, 16,
                    Component.literal("Mods"), b -> nohonor$openModsScreen(), this.font));
        }

        //Добавляем дополнительный воздух перед Options/Quit
        //Выполняется всегда: если мода нет, на месте кнопки останется пустое пространство
        topPos += lineGap * 1.9f;

        Component optionsLabel = Component.translatable("menu.options");
        Component quitLabel = Component.translatable("menu.quit");
        int optionsWidth = this.font.width(optionsLabel);
        int quitWidth = this.font.width(quitLabel);

        //Options/Quit сейчас стоят на topPos сразу после Realms (без доп. отступа,
        //т.к. строка с "topPos += lineGap * 1.8f" закомментирована вместе с кнопкой Mods)
        //визуальный разрыв перед Options/Quit
        //topPos += lineGap * 1.5f;

        this.addRenderableWidget(new PlainTextButton(left, (int) topPos, optionsWidth, 16,
                optionsLabel,
                b -> this.minecraft.gui.setScreen(new OptionsScreen(this, this.minecraft.options, false)), this.font));

        //16 - горизонтальный зазор между концом текста "Options..." и началом "Quit Game".
        //Больше -> кнопки дальше друг от друга по горизонтали.
        int quitX = left + optionsWidth + 30;
        this.addRenderableWidget(new PlainTextButton(quitX, (int) topPos, quitWidth, 16,
                quitLabel, b -> this.minecraft.stop(), this.font));

        //iconY - вертикальная позиция иконок friends/language/accessibility (нижний ряд).
        //this.height - 33 -> 33 пикселей от нижнего края экрана. Больше вычитаемое -> иконки выше.
        int iconY = this.height - 38;
        this.friends = (FriendsButton) this.addRenderableWidget(CommonButtons.friends(20,
                b -> OnlineOptionsScreen.confirmFriendsListEnabled(this.minecraft,
                        () -> this.minecraft.gui.setScreen(new FriendsOverlayScreen(this)), this),
                !this.minecraft.isDemo()));
        this.friends.setPosition(left - 111 + 30, iconY); // X = left, тот же отступ что и у меню сверху


        SpriteIconButton lang = (SpriteIconButton) this.addRenderableWidget(CommonButtons.language(20,
                b -> this.minecraft.gui.setScreen(new LanguageSelectScreen(this, this.minecraft.options, this.minecraft.getLanguageManager())), true));
        // left + 22 - X второй иконки. 22 = ширина иконки (20) + 2px зазор. Меняй вместе с access ниже.
        lang.setPosition(left - 111 + 22 + 30, iconY);

        SpriteIconButton access = (SpriteIconButton) this.addRenderableWidget(CommonButtons.accessibility(20,
                b -> this.minecraft.gui.setScreen(new AccessibilityOptionsScreen(this, this.minecraft.options)), true));
        // left + 44 - X третьей иконки. 44 = 22 * 2 (тот же шаг между иконками, что и у второй).
        access.setPosition(left - 111 + 44 + 30, iconY);

        this.realmsNotificationsScreen = new RealmsNotificationsScreen();
        this.realmsNotificationsScreen.init(this.width, this.height);

        ci.cancel();
    }

    private void nohonor$openModsScreen() {
        try {
            //Пытаемся найти класс экрана из ModMenu
            Class<?> modMenuClass = Class.forName("com.terraformersmc.modmenu.gui.ModsScreen");
            //Создаем экземпляр экрана и передаем текущий (this) как parent
            Screen modsScreen = (Screen) modMenuClass.getConstructor(Screen.class).newInstance(this);
            //Открываем экран
            this.minecraft.gui.setScreen(modsScreen);
        } catch (Exception e) {
            //Если ModMenu не установлен, кнопка просто ничего не сделает
            //Опционально: можно добавить звуковой сигнал об ошибке или лог
            System.out.println("NOHONOR: ModMenu не установлен!");
        }
    }

}