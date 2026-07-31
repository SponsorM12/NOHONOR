package zver.nohonor.client.mixin.effect;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.effect.ModEffects;

@Mixin(Minecraft.class)
public abstract class MinecraftDisarmMixin {
    //ОБЕЗОРУЖИВАНИЕ
    //Если коротко: чисто косметика, чтобы буквально блокировать анимации атаки и копания
    @Shadow @Nullable public LocalPlayer player;

    //Блокируем одиночный клик
    @Inject(method = "startAttack", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockStartAttackUnderDisarm(CallbackInfoReturnable<Boolean> cir) {
        if (this.player != null && this.player.hasEffect(ModEffects.DISARM)) {
            // Возвращаем false, ЛКМ буквально перестает инициировать действия
            cir.setReturnValue(false);
        }
    }

    //Блокируем зажатие
    @Inject(method = "continueAttack", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockContinueAttackUnderDisarm(boolean leftClick, CallbackInfo ci) {
        if (this.player != null && this.player.hasEffect(ModEffects.DISARM)) {
            //Отменяем выполнение метода - ломание блока прерывается
            ci.cancel();
        }
    }

}