package zver.nohonor.item.special;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import zver.nohonor.NOHONOR;

public final class SpecialItemDispatcher {
    private static final int INTERVAL = 20;

    public static void register() {
        ServerTickEvents.END_LEVEL_TICK.register(SpecialItemDispatcher::tick);
    }

    private static void tick(ServerLevel level) {
        boolean runSlowPath = level.getGameTime() % INTERVAL == 0;

        for (Entity entity : level.getAllEntities()) {
            if (entity instanceof ItemEntity itemEntity
                    && itemEntity.getItem().getItem() instanceof SpecialItemBehavior special) {
                special.onEveryTick(itemEntity, level);
                if (runSlowPath) {
                    special.onWorldTick(itemEntity, level);
                }
            }
        }
    }

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Special Items for " + NOHONOR.MOD_ID);
        register();
    }

}