package zver.nohonor.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import zver.nohonor.NOHONOR;
import zver.nohonor.sound.ModSounds;

import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {

    public ModSoundsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registryLookup, SoundExporter exporter) {
//=========================================================ЗВУКИ=============================================================
        //exporter.add(ModSounds.A, SoundTypeBuilder.of(ModSounds.A).subtitle("sounds.nohonor.a") //ОБЯЗАТЕЛЬНО В МОНО!!!
        //        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "_1")))
        //        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "_2")))
        //        .sound(SoundTypeBuilder.RegistrationBuilder.ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "_3"))
        //                .stream(true)
        //        )
        //);

//=========================================================МУЗЫКА=============================================================
        exporter.add(ModSounds.AME_IRO_RONDO, SoundTypeBuilder.of(ModSounds.AME_IRO_RONDO.value())
                .sound(SoundTypeBuilder.RegistrationBuilder
                        .ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "records/ame_iro_rondo"))
                        .stream(true)  //для длинных треков
                )
        );

        exporter.add(ModSounds.FULL_CONFESSION, SoundTypeBuilder.of(ModSounds.FULL_CONFESSION.value())
                .sound(SoundTypeBuilder.RegistrationBuilder
                        .ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "records/full_confession"))
                        .stream(true)
                )
        );

        exporter.add(ModSounds.MY_ONLY_CHANCE, SoundTypeBuilder.of(ModSounds.MY_ONLY_CHANCE.value())
                .sound(SoundTypeBuilder.RegistrationBuilder
                        .ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "records/my_only_chance"))
                        .stream(true)
                )
        );

        exporter.add(ModSounds.LOST_MY_PIECES, SoundTypeBuilder.of(ModSounds.LOST_MY_PIECES.value())
                .sound(SoundTypeBuilder.RegistrationBuilder
                        .ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "records/lost_my_pieces"))
                        .stream(true)
                )
        );

        exporter.add(ModSounds.V_MOYEY_GOLOVE, SoundTypeBuilder.of(ModSounds.V_MOYEY_GOLOVE.value())
                .sound(SoundTypeBuilder.RegistrationBuilder
                        .ofFile(Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "records/v_moyey_golove"))
                        .stream(true)
                )
        );

    }

    @Override
    public String getName() {
        return "NOHONOR Sounds Provider";
    }
}