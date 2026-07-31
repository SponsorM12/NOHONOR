package zver.nohonor.stat;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import zver.nohonor.NOHONOR;

public class ModStats {

    public static final Stat<?> TENACITY_RESTORED = makeCustomStat("tenacity_restored");

    private static Stat<?> makeCustomStat(String key) {
        Identifier identifier = Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, key);
        Identifier newStat = Registry.register(BuiltInRegistries.CUSTOM_STAT, key, identifier);
        return Stats.CUSTOM.get(newStat, StatFormatter.DEFAULT);
    }

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Stats for " + NOHONOR.MOD_ID);
    }
}
