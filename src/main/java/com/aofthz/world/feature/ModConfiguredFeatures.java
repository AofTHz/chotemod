package com.aofthz.world.feature;

import com.aofthz.block.ModBlock;
import com.aofthz.chotemod;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_CHOTERITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,ModBlock.CHOTERITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,ModBlock.DEEPSLATE_CHOTERITE_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CHOTERITE_ORE =
            ConfiguredFeatures.register("choterite_ore", Feature.ORE,new OreFeatureConfig(OVERWORLD_CHOTERITE_ORES,4));

    public static void registerConfiguredFeature(){
        chotemod.LOGGER.debug("Registering the ModConfiguredFeatures for" + chotemod.MOD_ID);
    }
}
