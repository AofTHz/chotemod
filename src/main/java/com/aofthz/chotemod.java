package com.aofthz;

import com.aofthz.world.feature.ModConfiguredFeatures;
import com.aofthz.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class chotemod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "chotemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("chotemod");

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ModConfiguredFeatures.registerConfiguredFeature();
        ModOreGeneration.generation();
        LOGGER.info("Hello Fabric world!");
        LOGGER.info("Never gonna give you up");
        LOGGER.info("Never gonna let you down");
    }
}