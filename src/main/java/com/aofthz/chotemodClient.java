package com.aofthz;

import com.aofthz.block.ModBlock;
import com.aofthz.entity.ModEntity;
import com.aofthz.entity.client.BerryRenderer;
import com.aofthz.event.KeyInputHandler;
import com.aofthz.item.ModItem;
import com.aofthz.networking.NetworkTest;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class chotemodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItem.registerModItem();
        ModBlock.registerModBlock();
        EntityRendererRegistry.register(ModEntity.BERRY, BerryRenderer::new);
        NetworkTest.registerS2CPackets();
        KeyInputHandler.register();
    }
}
