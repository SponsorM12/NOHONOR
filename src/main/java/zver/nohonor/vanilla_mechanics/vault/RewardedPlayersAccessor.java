package zver.nohonor.vanilla_mechanics.vault;

import java.util.Set;
import java.util.UUID;
//Доступ к приватному rewardedPlayers внутри VaultServerData
public interface RewardedPlayersAccessor {
    Set<UUID> nohonor$getRewardedPlayers();

}