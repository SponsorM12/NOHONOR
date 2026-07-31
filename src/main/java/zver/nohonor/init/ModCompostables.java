package zver.nohonor.init;

import net.fabricmc.fabric.api.registry.CompostableRegistry;
import zver.nohonor.block.ModBlocks;
import zver.nohonor.item.ModItems;

public class ModCompostables {

    public static void initialize() {
        CompostableRegistry.INSTANCE.add(ModBlocks.HESPERIDES_SAPLING, 0.5f); //значения - вероятность, а не точное количество
        CompostableRegistry.INSTANCE.add(ModBlocks.HESPERIDES_LEAVES, 0.3f);
        CompostableRegistry.INSTANCE.add(ModBlocks.GOLDEN_PETALS, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.MERCURILLIA_SEEDS, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.GREEN_APPLE, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.MAKOSH_BERRIES, 0.15f);
        CompostableRegistry.INSTANCE.add(ModItems.RICE_SHOOT, 0.25f);
        CompostableRegistry.INSTANCE.add(ModItems.RICE, 0.2f);
        CompostableRegistry.INSTANCE.add(ModItems.BEAN_POD, 0.3f);
        CompostableRegistry.INSTANCE.add(ModItems.BEANS, 0.3f);
    }

}
