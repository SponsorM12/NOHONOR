package zver.nohonor.networking.packet;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import zver.nohonor.NOHONOR;

//С - Клиент, 2- to, S -Сервер, c2s
public record ModPayloadC2S (String name, int value //,ItemStack stack
) implements CustomPacketPayload {

    public static final Type<ModPayloadC2S> TYPE = new Type<>(
            Identifier.fromNamespaceAndPath(NOHONOR.MOD_ID, "mod_payload_c2s"));

    //CODEC -> Codec & StreamCodec
    //Codec Позволяет создавать Java объекты к примеру JSON и записывать в JSON
    //
    //StreamCodec - Java Objects => Отправляет трафик Networl bytes
    //делает из bytes в Object
    //

    public static final StreamCodec<RegistryFriendlyByteBuf, ModPayloadC2S> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            ModPayloadC2S::name,

            ByteBufCodecs.VAR_INT,
            ModPayloadC2S::value,
            //сюда можно так же по примеру модовые классы
            //ItemStack.STREAM_CODEC,
            //ModPayloadC2S::stack,

            ModPayloadC2S::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

}
