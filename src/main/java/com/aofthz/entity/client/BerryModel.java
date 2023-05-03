package com.aofthz.entity.client;

import com.aofthz.chotemod;
import com.aofthz.entity.custom.Berry;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class BerryModel extends AnimatedGeoModel<Berry> {
    @Override
    public Identifier getModelResource(Berry object) {
        return new Identifier(chotemod.MOD_ID,"geo/berry.geo.json");
    }

    @Override
    public Identifier getTextureResource(Berry object) {
        return new Identifier(chotemod.MOD_ID,"textures/entity/berry.png");
    }

    @Override
    public Identifier getAnimationResource(Berry animatable) {
        return new Identifier(chotemod.MOD_ID,"animations/berryanimation.json");
    }

    @SuppressWarnings({"unchecked","rawtype"})
    @Override
    public void setCustomAnimations(Berry animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null){
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw *((float) Math.PI/180F));
        }
    }
}
