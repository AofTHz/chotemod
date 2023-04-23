package com.aofthz.item;

import com.aofthz.chotemod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CHOTERITE = FabricItemGroupBuilder.build(
            new Identifier(chotemod.MOD_ID, "choterite"), () -> new ItemStack(ModItem.CHOTE));
}
