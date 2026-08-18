package zver.nohonor.networking;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import zver.nohonor.networking.packet.ModPayloadC2S;

public class ModPackets {

    private static void registerClientbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry) {

    }

    private static void registerServerbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry) {
        registry.register(ModPayloadC2S.TYPE, ModPayloadC2S.STREAM_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ModPayloadC2S.TYPE, ServerboundPackets::handlePayload);
    }

    //Если игрок делает что-то на клиенте (нажал клавишу, кликнул GUI-кнопку),
    //а нужно чтобы это повлияло на реальный мир Server (заспавнило сущность, изменило блок, дало эффект)
    //клиент не может это сделать сам, он должен попросить сервер это сделать
    //
    //Если сервер хочет показать что-то только визуально (партиклы, звук, рендер, обновление кастомного HUD)
    //он должен сообщить об этом клиенту, потому что рендерингом занимается только клиент
    //
    //Важный нюанс: для постоянной синхронизации состояния сущности (как c Tenacity через SynchedEntityData,
    //или отражение через hasEffect) пакеты напрямую не нужны - SynchedEntityData под капотом
    //сама шлёт нужные пакеты автоматически при каждом изменении
    //Кастомные пакеты пишутся руками именно под разовые события/команды, а не под непрерывный стрим состояния

    public static void initialize() {
        registerClientbound(PayloadTypeRegistry.clientboundPlay());
        registerServerbound(PayloadTypeRegistry.serverboundPlay());
    }

}
