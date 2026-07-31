package zver.nohonor.vanilla_mechanics.vault;

public interface VaultRenewalTracker {
    //Храним момент последнего успешного открытия кейса vault world.getTime
    long nohonor$getLockedUntil();
    //Храним моент до которого vault будет заблокирован ДЛЯ ВСЕХ ИГРОКОВ
    void nohonor$setLockedUntil(long time);

}
