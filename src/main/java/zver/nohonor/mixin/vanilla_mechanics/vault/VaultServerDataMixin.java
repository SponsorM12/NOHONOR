package zver.nohonor.mixin.vanilla_mechanics.vault;

import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.minecraft.world.level.block.entity.vault.VaultServerData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import zver.nohonor.vanilla_mechanics.vault.RewardedPlayersAccessor;
import zver.nohonor.vanilla_mechanics.vault.VaultRenewalTracker;

import java.util.Set;
import java.util.UUID;

@Mixin(VaultServerData.class)
public abstract class VaultServerDataMixin implements RewardedPlayersAccessor, VaultRenewalTracker {

    @Shadow @Final
    private Set<UUID> rewardedPlayers;

    @Unique
    private long nohonor$lockedUntil = 0L;

    @Override
    public Set<UUID> nohonor$getRewardedPlayers() {
        return this.rewardedPlayers;
    }

    @Override
    public long nohonor$getLockedUntil() {
        return this.nohonor$lockedUntil;
    }

    @Override
    public void nohonor$setLockedUntil(long time) {
        this.nohonor$lockedUntil = time;
    }

}