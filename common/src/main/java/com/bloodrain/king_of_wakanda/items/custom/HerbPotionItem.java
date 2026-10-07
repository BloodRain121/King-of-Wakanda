package com.bloodrain.king_of_wakanda.items.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.threetag.palladium.power.SuperpowerUtil;

public class HerbPotionItem extends Item {
    private static final int DRINK_DURATION = 40;

    public HerbPotionItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(stack, level, livingEntity);
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            SuperpowerUtil.setSuperpower(livingEntity, ResourceLocation.tryParse("king_of_wakanda:black_panther_power"));
        }

        if (!level.isClientSide) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 0, false, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 6, false, true));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 200, false, true));
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.BOWL);
        } else {
            if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
                ItemStack itemStack = new ItemStack(Items.BOWL);
                Player player = (Player)livingEntity;
                if (!player.getInventory().add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }

            return stack;
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
