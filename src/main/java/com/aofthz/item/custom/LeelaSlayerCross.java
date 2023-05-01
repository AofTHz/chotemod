package com.aofthz.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LeelaSlayerCross extends Item {

    public LeelaSlayerCross(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if(!world.isClient() && entity.isPlayer()&& selected || ((PlayerEntity) entity).getOffHandStack().isItemEqual(stack.getItem().getDefaultStack())){
            TestFucntion((PlayerEntity) entity);

        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("But he actually looking for your mom!").formatted(Formatting.DARK_GRAY));
        }else {
            tooltip.add(Text.literal("Something watching over you...").formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void TestFucntion(PlayerEntity player){

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,1,1));
    }
}
