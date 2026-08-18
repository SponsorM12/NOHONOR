package zver.nohonor.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import zver.nohonor.networking.packet.ModPayloadC2S;

public class ServerboundPackets {

    public static void handlePayload(ModPayloadC2S payload, ServerPlayNetworking.Context context) {
        //EntityTypes.COW.spawn(context.player().level(), context.player().getOnPos(), EntitySpawnReason.TRIGGERED);

    }

}
