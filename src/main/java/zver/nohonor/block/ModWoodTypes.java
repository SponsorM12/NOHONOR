package zver.nohonor.block;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;

public class ModWoodTypes {
    //ДЛЯ УКАЗАНИЯ ТИПА МОДОВОГО ДЕРЕВА:
    public static final BlockSetType HESPERIDES_SET_TYPE =
            BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY)
                    .soundType(SoundType.CHERRY_WOOD)
                    .register(Identifier.fromNamespaceAndPath("nohonor", "hesperides"));
    //ДЛЯ РАБОТЫ ВОРОТ:
    public static final WoodType HESPERIDES =
            WoodTypeBuilder.copyOf(WoodType.CHERRY)
                    .soundType(SoundType.CHERRY_WOOD)
                    .hangingSignSoundType(SoundType.CHERRY_WOOD_HANGING_SIGN)
                    .fenceGateCloseSound(SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE)
                    .fenceGateOpenSound(SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN)
                    .register(Identifier.fromNamespaceAndPath("nohonor", "hesperides"), HESPERIDES_SET_TYPE);

//public static final BlockSetType HESPERIDES_SET_TYPE =
//        new BlockSetType("hesperides");


//    public static final WoodType HESPERIDES =
//            new WoodType(
//                    "hesperides",
//                    HESPERIDES_SET_TYPE,
//                    SoundType.CHERRY_WOOD,
//                    SoundType.CHERRY_WOOD_HANGING_SIGN,
//                    SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE,
    //                   SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN
    //          );

//АНАЛОГИЧНО КАК И У ГЕСПЕРИДЫ ДЛЯ ВЯЗА:

//    public static final BlockSetType ELM_SET_TYPE =
//            new BlockSetType("elm");
//ДЛЯ РАБОТЫ ВОРОТ:
//    public static final WoodType ELM =
//            new WoodType(
//                    "elm",
//                    ELM_SET_TYPE,
//                   SoundType.WOOD,
//                    SoundType.HANGING_SIGN,
//                    SoundEvents.FENCE_GATE_CLOSE,
//                    SoundEvents.FENCE_GATE_OPEN
//            );

    public static void initialize() {

    }
}