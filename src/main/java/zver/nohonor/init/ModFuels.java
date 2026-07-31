package zver.nohonor.init;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import zver.nohonor.item.ModItems;

public class ModFuels {

    public static void initialize() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            //Значения:
            //уголь 1600
            //блейз 2400
            //лавабакет 20000
            //планкс 300
            //200=1 предмет в среднем
            //палка 100

            builder.add(ModItems.CHARRED_STONE, 20000);
            //context.

        });
    }

}
