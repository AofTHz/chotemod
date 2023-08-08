package com.aofthz.entity.custom;

import com.aofthz.entity.ModEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class Berry extends PassiveEntity implements IAnimatable, Inventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Berry(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : inventory) {
            if (!itemStack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        if (slot >= 0 && slot < inventory.size()) {
            return inventory.get(slot);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot) {
        return null;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        if (slot >= 0 && slot < inventory.size()) {
            inventory.set(slot, stack);
        }

    }

    @Override
    public void clear() {
        inventory.clear();
    }

    @Override
    public void markDirty() {

    }

    /*
        @Override
        public ActionResult interactMob(PlayerEntity player, Hand hand) {
            if (player.isSneaking()) {
                return ActionResult.PASS;
            } else if (!player.world.isClient) {
                player.openHandledScreen(new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
                    return new EntityInventoryScreenHandler(i, playerInventory, this);
                }, new TranslatableText("container.inventory")));
            }
            return ActionResult.SUCCESS;
        }
    */
    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    public static DefaultAttributeContainer.Builder setAttribute(){
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f);
    }

    @Override
    protected void initGoals(){
            this.goalSelector.add(1,new SwimGoal(this));
            this.goalSelector.add(2,new EscapeDangerGoal(this,1.8f));
            this.goalSelector.add(3, new WanderAroundFarGoal(this,0.75f,1));

            this.goalSelector.add(4, new LookAroundGoal(this));

            this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class,true));
            this.targetSelector.add(3,new ActiveTargetGoal<>(this, MerchantEntity.class,true));
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {

        return ModEntity.BERRY.create(world);
    }


    @Override
    protected void mobTick() {
        double d = this.getMovementSpeed();
        if(d < 0.25f){
            setSprinting(false);
        }else if(d>= 0.3f && this.moveControl.isMoving()){
            setSprinting(true);
        }else{
            setSprinting(false);
        }

    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if (event.isMoving()){
            if(this.isSprinting()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.berry.running", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            }else{
                {
                    event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.berry.walking", ILoopType.EDefaultLoopTypes.LOOP));
                    return PlayState.CONTINUE;
                }
            }
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.berry.idle",ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @SuppressWarnings({"unchecked","rawtype"})
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this,"controller",
                0,this::predicate));
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_FOX_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP,0.15f,1.0f);
    }

}