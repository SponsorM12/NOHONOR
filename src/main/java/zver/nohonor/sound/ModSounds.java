package zver.nohonor.sound;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import zver.nohonor.NOHONOR;

public class ModSounds {

    //public static final SoundEvent A = registerSoundEvent(".a");

    public static final Holder.Reference<SoundEvent> AME_IRO_RONDO = registerJukeboxSong("music_disc.ame_iro_rondo");
    public static final Holder.Reference<SoundEvent> FULL_CONFESSION = registerJukeboxSong("music_disc.full_confession");
    public static final Holder.Reference<SoundEvent> MY_ONLY_CHANCE = registerJukeboxSong("music_disc.my_only_chance");
    public static final Holder.Reference<SoundEvent> LOST_MY_PIECES = registerJukeboxSong("music_disc.lost_my_pieces");
    public static final Holder.Reference<SoundEvent> V_MOYEY_GOLOVE = registerJukeboxSong("music_disc.v_moyey_golove");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    private static Holder.Reference<SoundEvent> registerJukeboxSong(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void initialize() {
        NOHONOR.LOGGER.info("Registering Sounds for " + NOHONOR.MOD_ID);
    }
}