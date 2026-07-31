// zver/nohonor/world/tree/ModTreeGrowers.java
package zver.nohonor.world.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import zver.nohonor.world.feature.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower HESPERIDES = new TreeGrower(
            "nohonor:hesperides",
            Optional.empty(),         //megaTree
            Optional.of(ModConfiguredFeatures.HESPERIDES_TREE),      //tree ConfiguredFeature
            Optional.empty()                    //flowers (какие еще flowers?)
    );

    public static final TreeGrower ELM = new TreeGrower(
            "nohonor:elm",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.ELM_TREE),
            Optional.empty()
    );

}