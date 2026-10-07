package com.bloodrain.king_of_wakanda.items.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class NecklaceItem extends Item implements Equipable {
    public NecklaceItem(Item.Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return this.swapWithEquipmentSlot(this, level, player, usedHand);
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.CHEST;
    }
}
