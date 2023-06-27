package com.aofthz.networking.packet;

import com.aofthz.entity.ModEntity;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class Client2ServerPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf,PacketSender respsoneSender){
        ModEntity.BERRY.spawn(((ServerWorld) player.world),null,null,player,player.getBlockPos(), SpawnReason.TRIGGERED,true,false);
    }
}
