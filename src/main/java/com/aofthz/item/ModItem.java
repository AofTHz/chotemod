package com.aofthz.item;


import com.aofthz.chotemod;
import com.aofthz.item.custom.LeelaSlayerCross;
import com.aofthz.item.custom.b_sword;
import com.aofthz.item.custom.glock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItem {

    public static final Item RAW_CHOTE = registerItem("raw_chote",
            new Item(new FabricItemSettings().group(ModItemGroup.CHOTERITE)));
    public static final Item CHOTE = registerItem("chote",
            new Item(new FabricItemSettings().group(ModItemGroup.CHOTERITE)));
    public static final Item LEELASLAYERCROSS = registerItem("leelaslayer_cross",
            new LeelaSlayerCross(new FabricItemSettings().group(ModItemGroup.CHOTERITE).maxCount(1)));
    public static final Item GLOCK = registerItem("glock",
            new glock(new FabricItemSettings().group(ModItemGroup.CHOTERITE).maxCount(1)));
    public static final Item B_SWORD = registerItem("b_sword",
            new b_sword(ToolMaterials.NETHERITE,9,-3.3f,
                    new FabricItemSettings().group(ModItemGroup.CHOTERITE)));
    private static Item registerItem(String name,Item item){
        return Registry.register(Registry.ITEM, new Identifier(chotemod.MOD_ID, name), item);
    }


    public static void registerModItem(){
        chotemod.LOGGER.debug("Registering Mod Item for "+ chotemod.MOD_ID);
    }


}
