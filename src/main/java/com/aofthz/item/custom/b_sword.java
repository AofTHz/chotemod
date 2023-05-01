package com.aofthz.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class b_sword extends SwordItem {
    boolean powerup = false;
    public b_sword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("คนเหี้ยอะไรเสียงดังชิปหาย").formatted(Formatting.GRAY));
        }else {
            tooltip.add(Text.literal("ลูกกระเดือกปีศาจ").formatted(Formatting.AQUA));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!powerup && !world.isClient && hand == Hand.MAIN_HAND) {
        powerup = true;
        user.getItemCooldownManager().set(this,10);
        world.playSound(null,user.getX(),user.getY(),user.getZ(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.PLAYERS,1,1);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,2,0));
        }
        return super.use(world, user, hand);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (powerup) {
            if(target.isBlocking()){
                target.disablesShield();
                target.damage(DamageSource.player((PlayerEntity) attacker), 10);
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,2,4));
            }else{
                target.damage(DamageSource.player((PlayerEntity) attacker), 4);
            }
            target.setOnFire(true);
            target.setFireTicks(60);
            powerup = false;
            ((PlayerEntity) attacker).getItemCooldownManager().set(this,100);
            return super.postHit(stack, target, attacker);
        } else {
            return super.postHit(stack, target, attacker);
        }

    }
}
