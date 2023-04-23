package com.aofthz;

import com.aofthz.block.ModBlock;
import com.aofthz.item.ModItem;
import net.fabricmc.api.ClientModInitializer;

public class chotemodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModItem.registerModItem();
        ModBlock.registerModBlock();
    }
}
