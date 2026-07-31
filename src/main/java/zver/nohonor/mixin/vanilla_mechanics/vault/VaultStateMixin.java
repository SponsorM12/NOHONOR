package zver.nohonor.mixin.vanilla_mechanics.vault;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.vault.VaultConfig;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import net.minecraft.world.level.block.entity.vault.VaultSharedData;
import net.minecraft.world.level.block.entity.vault.VaultState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zver.nohonor.vanilla_mechanics.vault.RewardedPlayersAccessor;
import zver.nohonor.vanilla_mechanics.vault.VaultRenewalTracker;

@Mixin(VaultState.class)
public abstract class VaultStateMixin {

    @Inject(method = "tickAndGetNext", at = @At("HEAD"), cancellable = true)
    private void nohonor$sleepDuringCooldown(ServerLevel level, BlockPos pos, VaultConfig config,
                                             VaultServerData serverData, VaultSharedData sharedData,
                                             CallbackInfoReturnable<VaultState> cir) {
        VaultState self = (VaultState) (Object) this;

        //Вмешиваемся ТОЛЬКО если хранилище находится в покое.
        //Не прерываем анимации UNLOCKING и EJECTING
        if (self == VaultState.INACTIVE) {
            VaultRenewalTracker tracker = (VaultRenewalTracker) serverData;
            long lockedUntil = tracker.nohonor$getLockedUntil();

            if (lockedUntil > 0) {
                if (level.getGameTime() < lockedUntil) {
                    //Время еще не вышло — принудительно оставляем хранилище спящим
                    cir.setReturnValue(VaultState.INACTIVE);
                } else {
                    //Кулдаун завершился в этот самый тик!
                    //Безопасно очищаем ванильный список награжденных игроков.
                    ((RewardedPlayersAccessor) serverData).nohonor$getRewardedPlayers().clear();
                    //Сбрасываем таймер
                    tracker.nohonor$setLockedUntil(0L);
                }
            }
        }
    }
}