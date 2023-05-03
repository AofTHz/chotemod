package com.aofthz.entity;

import com.aofthz.chotemod;
import com.aofthz.entity.custom.Berry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntity {
    public static final EntityType<Berry> BERRY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(chotemod.MOD_ID,"berry"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Berry::new)
                    .dimensions(EntityDimensions.fixed(0.5f,1f)).build());

}
