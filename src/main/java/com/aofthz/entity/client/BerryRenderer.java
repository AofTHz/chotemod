package com.aofthz.entity.client;

import com.aofthz.chotemod;
import com.aofthz.entity.custom.Berry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BerryRenderer extends GeoEntityRenderer<Berry> {
    public BerryRenderer(EntityRendererFactory.Context ctx){
        super(ctx, new BerryModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(Berry animatable) {
        return new Identifier(chotemod.MOD_ID,"textures/entity/berry.png");
    }

    @Override
    public RenderLayer getRenderType(Berry animatable, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, VertexConsumer buffer, int packedLight, Identifier texture) {
        poseStack.scale(1.2f,1.2f,1.2f);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
