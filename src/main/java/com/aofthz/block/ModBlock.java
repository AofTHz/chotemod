package com.aofthz.block;

import com.aofthz.chotemod;
import com.aofthz.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlock {
    public static final Block CHOTERITE_BLOCK = registerBlock("choterite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.CHOTERITE);
    public static final Block CHOTERITE_ORE = registerBlock("choterite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.CHOTERITE);
    public static final Block DEEPSLATE_CHOTERITE_ORE = registerBlock("deepslate_choterite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(5f).requiresTool(),
                    UniformIntProvider.create(3, 7)),ModItemGroup.CHOTERITE);
    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name,block,tab);
        return Registry.register(Registry.BLOCK, new Identifier(chotemod.MOD_ID, name),block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(chotemod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlock(){
        chotemod.LOGGER.debug("Registering ModBlock for "+chotemod.MOD_ID);
    }
}
