package com.aofthz.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

public class BerryInventoryScreenHandler extends ScreenHandler {
    public BerryInventoryScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(null, syncId);
        // Implementation goes here
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
    // Implementation goes here
}