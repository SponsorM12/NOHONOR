package zver.nohonor.datagen;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import zver.nohonor.NOHONOR;

import java.util.Optional;

public class ModPaintings {
    //КАРТИНЫ
    //1 на 1
    public static final ResourceKey<PaintingVariant> COOL_ECHPOCHMAK = create("cool_echpochmak");
    public static final ResourceKey<PaintingVariant> FIRST_PLANET = create("first_planet");
    public static final ResourceKey<PaintingVariant> GLADIATOR = create("gladiator");

    //2 а 2

    //2 на 3
    public static final ResourceKey<PaintingVariant> NIAN = create("nian");

    //3 на 3
    public static final ResourceKey<PaintingVariant> STUDY = create("study");
    public static final ResourceKey<PaintingVariant> MOUSE = create("mouse");

    //3 на 4
    public static final ResourceKey<PaintingVariant> ANGER = create("anger");

    //4 на 4
    public static final ResourceKey<PaintingVariant> BASYA = create("basya");
    public static final ResourceKey<PaintingVariant> LUCHI_0 = create("luchi_0");
    public static final ResourceKey<PaintingVariant> LUCHI_1 = create("luchi_1");
    public static final ResourceKey<PaintingVariant> LUCHI_2 = create("luchi_2");

    //5 на 3
    public static final ResourceKey<PaintingVariant> SHAMAN = create("shaman");

    //5 на 5
    public static final ResourceKey<PaintingVariant> BILLY = create("billy");
    public static final ResourceKey<PaintingVariant> MIRELLE = create("mirelle");
    public static final ResourceKey<PaintingVariant> LONA = create("lona");
    public static final ResourceKey<PaintingVariant> CHERNOBOG = create("chernobog");
    public static final ResourceKey<PaintingVariant> ROZMARI = create("rozmari");
    public static final ResourceKey<PaintingVariant> LUCHI_5 = create("luchi_5");

    //8 на 8
    public static final ResourceKey<PaintingVariant> SYBIL = create("sybil");

    //Размер и авторство
    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        register(context, COOL_ECHPOCHMAK, 1, 1, true);
        register(context, FIRST_PLANET, 1, 1, true);
        register(context, GLADIATOR, 1, 1, true);

        register(context, NIAN, 2, 3, true);

        register(context, STUDY, 3, 3, true);
        register(context, MOUSE, 3, 3, true);

        register(context, ANGER, 3, 4, true);

        register(context, BASYA, 4, 4, true);
        register(context, LUCHI_0, 4, 4, true);
        register(context, LUCHI_1, 4, 4, true);
        register(context, LUCHI_2, 4, 4, true);

        register(context, SHAMAN, 5, 3, true);

        register(context, BILLY, 5, 5, true);
        register(context, MIRELLE, 5, 5, true);
        register(context, LONA, 5, 5, true);
        register(context, CHERNOBOG, 5, 5, true);
        register(context, ROZMARI, 5, 5, true);
        register(context, LUCHI_5, 5, 5, true);

        register(context, SYBIL, 8, 8, true);

    }

    private static ResourceKey<PaintingVariant> create(final String id) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, id));
    }
    private static void register(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final int widt,
                                 final int height, final boolean hasAuthor
    ) {
        context.register(key, new PaintingVariant(widt, height, key.identifier(),
                Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW)),
                hasAuthor ? Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY)) : Optional.empty()));
    }
}
