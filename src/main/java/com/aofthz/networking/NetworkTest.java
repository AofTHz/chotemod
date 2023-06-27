package com.aofthz.networking;

import com.aofthz.chotemod;
import com.aofthz.networking.packet.Client2ServerPacket;
import com.aofthz.networking.packet.Water2ClientPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class NetworkTest {
    public static final Identifier GAIN_MANA_ID = new Identifier(chotemod.MOD_ID,"gain_mana");
    public static final Identifier MANA_SYNC_ID = new Identifier(chotemod.MOD_ID,"mana_sync");
    public static final Identifier MANA_POINT_ID = new Identifier(chotemod.MOD_ID,"mana_point");

    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(MANA_POINT_ID, Client2ServerPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(GAIN_MANA_ID, Water2ClientPacket::receive);
    }
    public static void registerS2CPackets(){

    }
}
