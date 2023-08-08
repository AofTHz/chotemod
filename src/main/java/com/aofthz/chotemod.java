package com.aofthz;

import com.aofthz.entity.ModEntity;
import com.aofthz.entity.custom.Berry;
import com.aofthz.gui.BerryInventoryScreenHandler;
import com.aofthz.networking.NetworkTest;
import com.aofthz.world.feature.ModConfiguredFeatures;
import com.aofthz.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class chotemod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "chotemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("chotemod");
    public static final ScreenHandlerType<BerryInventoryScreenHandler> BERRY_INVENTORY_SCREEN_HANDLER;

    static {
        BERRY_INVENTORY_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
                new Identifier("chotemod", "berry_inventory"),
                BerryInventoryScreenHandler::new
        );
    }
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ModConfiguredFeatures.registerConfiguredFeature();
        ModOreGeneration.generation();
        GeckoLib.initialize();
        FabricDefaultAttributeRegistry.register(ModEntity.BERRY, Berry.setAttribute());
        LOGGER.info("Hello Fabric world!");
        LOGGER.info("Never gonna give you up");
        LOGGER.info("Never gonna let you down");
        NetworkTest.registerC2SPackets();

    }
}