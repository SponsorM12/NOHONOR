package zver.nohonor.mixin.vanilla_mechanics.vault;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.entity.vault.VaultBlockEntity;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zver.nohonor.vanilla_mechanics.vault.VaultRenewalTracker;

@Mixin(VaultBlockEntity.class)
public abstract class VaultBlockEntityMixin {

    @Shadow @Final private VaultServerData serverData;

    @Inject(method = "saveAdditional", at = @At("TAIL"))
    private void nohonor$saveAdditional(ValueOutput output, CallbackInfo ci) {
        output.store("nohonor_locked_until", Codec.LONG, ((VaultRenewalTracker) this.serverData).nohonor$getLockedUntil());
    }

    @Inject(method = "loadAdditional", at = @At("TAIL"))
    private void nohonor$loadAdditional(ValueInput input, CallbackInfo ci) {
        long lockedUntil = input.read("nohonor_locked_until", Codec.LONG).orElse(0L);
        ((VaultRenewalTracker) this.serverData).nohonor$setLockedUntil(lockedUntil);
    }
}