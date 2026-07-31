package zver.nohonor.sound;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;
import zver.nohonor.NOHONOR;
import zver.nohonor.sound.ModSounds;

public class ModJukeboxSongs {

    //Ключ для пластинки
    public static final ResourceKey<JukeboxSong> AME_IRO_RONDO_KEY = ResourceKey.create(
            Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "music_disc_ame_iro_rondo")
    );

    public static final ResourceKey<JukeboxSong> FULL_CONFESSION_KEY = ResourceKey.create(
            Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "music_disc_full_confession")
    );

    public static final ResourceKey<JukeboxSong> MY_ONLY_CHANCE_KEY = ResourceKey.create(
            Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "music_disc_my_only_chance")
    );

    public static final ResourceKey<JukeboxSong> V_MOYEY_GOLOVE_KEY = ResourceKey.create(
            Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "music_disc_v_moyey_golove")
    );

    public static final ResourceKey<JukeboxSong> LOST_MY_PIECES_KEY = ResourceKey.create(
            Registries.JUKEBOX_SONG,
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "music_disc_lost_my_pieces")
    );

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, AME_IRO_RONDO_KEY, ModSounds.AME_IRO_RONDO, 134, 1);
        register(context, FULL_CONFESSION_KEY, ModSounds.FULL_CONFESSION, 244, 2);
        register(context, MY_ONLY_CHANCE_KEY, ModSounds.MY_ONLY_CHANCE, 408, 15);
        register(context, V_MOYEY_GOLOVE_KEY, ModSounds.V_MOYEY_GOLOVE, 164, 13);
        register(context, LOST_MY_PIECES_KEY, ModSounds.LOST_MY_PIECES, 121, 13);
    }

    public static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key,
                                 Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comporatorOutput) {

        context.register(key, new  JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())), lengthInSeconds, comporatorOutput));

    }
}