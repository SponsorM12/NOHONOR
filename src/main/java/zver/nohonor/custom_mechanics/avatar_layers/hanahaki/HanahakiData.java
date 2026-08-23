package zver.nohonor.custom_mechanics.avatar_layers.hanahaki;

import org.jspecify.annotations.Nullable;

public interface HanahakiData {

    //null = эффект ни разу не применялся (или синхронизация ещё не пришла)
    @Nullable String getHanahakiVariant();
    void setHanahakiVariant(@Nullable String variant);

}