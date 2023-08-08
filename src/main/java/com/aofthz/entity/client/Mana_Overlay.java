package com.aofthz.entity.client;

import com.aofthz.chotemod;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class Mana_Overlay implements HudRenderCallback {
    private static final Identifier FILLED_MANA = new Identifier(chotemod.MOD_ID,"");
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

    }
}
