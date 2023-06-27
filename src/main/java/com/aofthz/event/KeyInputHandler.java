package com.aofthz.event;

import com.aofthz.networking.NetworkTest;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_CHOTEMOD = "key.category.chotemod.test";
    public static final String KEY_BUTTON1_CHOTEMOD = "key.chotemod.gain_mana";

    public static KeyBinding gainmanaKey;

    public static void registerKeyInput(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(gainmanaKey.wasPressed()){
                ClientPlayNetworking.send(NetworkTest.GAIN_MANA_ID, PacketByteBufs.create());

            }
        });
    }
    public static void register(){
        gainmanaKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_BUTTON1_CHOTEMOD,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                KEY_CATEGORY_CHOTEMOD
        ));
        registerKeyInput();
    }
}
