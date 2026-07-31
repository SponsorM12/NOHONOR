package zver.nohonor.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import zver.nohonor.particle.ModParticles;

public class ModLeavesBlocks extends LeavesBlock {

    public static final MapCodec<ModLeavesBlocks> CODEC =
            simpleCodec(ModLeavesBlocks::new);

    public ModLeavesBlocks(Properties properties) {
        super(0.02f, properties); //0.02f - шанс появления частиц листьев
    }

    //СПАВН ЧАСТИЦ РАБОТАЕТ!!!
    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide()) return;

        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() - 0.05;
        double z = pos.getZ() + random.nextDouble();

        level.addParticle(
                ModParticles.HESPERIDES_LEAF,
                x, y, z,
                0.0, -0.05, 0.0
        );
    }

    //А ЭТО ДЛЯ ЧЕГО НАПОМНИ?
    @Override
    public MapCodec<? extends LeavesBlock> codec() {
        return CODEC;
    }
}