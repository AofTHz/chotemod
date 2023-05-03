package com.aofthz;

import com.aofthz.block.ModBlock;
import com.aofthz.entity.ModEntity;
import com.aofthz.entity.client.BerryRenderer;
import com.aofthz.item.ModItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class chotemodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItem.registerModItem();
        ModBlock.registerModBlock();
        EntityRendererRegistry.register(ModEntity.BERRY, BerryRenderer::new);
    }
}
