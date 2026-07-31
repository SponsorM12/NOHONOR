package zver.nohonor.mixin.vanilla_mechanics.vault;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.vault.VaultConfig;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import net.minecraft.world.level.block.entity.vault.VaultSharedData;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.vanilla_mechanics.vault.VaultRenewalTracker;

@Mixin(net.minecraft.world.level.block.entity.vault.VaultBlockEntity.Server.class)
public class VaultBlockServerMixin {

    private static final long NOHONOR_COOLDOWN_TICKS = 20 * 60 * 2; // 2 минуты

    @Inject(method = "tryInsertKey", at = @At("HEAD"), cancellable = true)
    private static void nohonor$blockDuringLockout(ServerLevel level, BlockPos pos, BlockState state,
                                                   VaultConfig config, VaultServerData serverData,
                                                   VaultSharedData sharedData, Player player,
                                                   ItemStack stackToInsert, CallbackInfo ci) {

        if (level.getGameTime() < ((VaultRenewalTracker) serverData).nohonor$getLockedUntil()) {
            ci.cancel();
        }
    }

    @Inject(method = "tryInsertKey", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/entity/vault/VaultServerData;addToRewardedPlayers(Lnet/minecraft/world/entity/player/Player;)V",
            shift = At.Shift.AFTER))
    private static void nohonor$startLockout(ServerLevel level, BlockPos pos, BlockState state,
                                             VaultConfig config, VaultServerData serverData,
                                             VaultSharedData sharedData, Player player,
                                             ItemStack stackToInsert, CallbackInfo ci) {
        //Устанавливаем кулдаун
        ((VaultRenewalTracker) serverData).nohonor$setLockedUntil(level.getGameTime() + NOHONOR_COOLDOWN_TICKS);
    }
}