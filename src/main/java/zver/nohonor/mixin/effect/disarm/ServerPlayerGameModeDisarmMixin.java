package zver.nohonor.mixin.effect.disarm;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.effect.ModEffects;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeDisarmMixin {
    //Обезоруживание
    //Не совсем понял
    @Shadow @Final protected ServerPlayer player;

    @Inject(method = "handleBlockBreakAction", at = @At("HEAD"), cancellable = true)
    private void nohonor$blockBreakUnderDisarm(BlockPos pos, ServerboundPlayerActionPacket.Action action,
                                               Direction direction, int maxY, int sequence, CallbackInfo ci) {
        if (action == ServerboundPlayerActionPacket.Action.START_DESTROY_BLOCK
                && this.player.hasEffect(ModEffects.DISARM)) {
            //Запрет на ломание блока
            ci.cancel();
        }
    }

}