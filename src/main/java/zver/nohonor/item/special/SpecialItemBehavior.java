package zver.nohonor.item.special;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;

public interface SpecialItemBehavior {

    //Раз в INTERVAL тиков - для "взрывных" реакций
    default void onWorldTick(ItemEntity itemEntity, ServerLevel level) {
    }

    //Каждый тик - для непрерывной физики
    default void onEveryTick(ItemEntity itemEntity, ServerLevel level) {
    }

}