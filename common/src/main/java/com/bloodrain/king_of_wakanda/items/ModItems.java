package com.bloodrain.king_of_wakanda.items;

import com.bloodrain.king_of_wakanda.KingOfWakanda;
import com.bloodrain.king_of_wakanda.items.custom.HerbPotionItem;
import com.bloodrain.king_of_wakanda.items.custom.NecklaceItem;
import net.minecraft.world.item.*;
import net.threetag.palladium.item.AddonArmorItem;
import net.threetag.palladiumcore.registry.CreativeModeTabRegistry;
import net.threetag.palladiumcore.registry.DeferredRegister;
import net.threetag.palladiumcore.registry.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(KingOfWakanda.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> HERB_POTION = ITEMS.register("herb_potion", () -> new HerbPotionItem(new Item.Properties().food(new FoodProperties.Builder().build()).stacksTo(1)));
    public static final RegistrySupplier<Item> NECKLACE = ITEMS.register("black_panther_necklace", () -> new NecklaceItem(new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CIVIL_WAR_HELMET = ITEMS.register("black_panther_civil_war_helmet", () -> new AddonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CIVIL_WAR_CHESTPLATE = ITEMS.register("black_panther_civil_war_chestplate", () -> new AddonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CIVIL_WAR_LEGGINGS = ITEMS.register("black_panther_civil_war_leggings", () -> new AddonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CIVIL_WAR_BOOTS = ITEMS.register("black_panther_civil_war_boots", () -> new AddonArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CLASSIC_MASK = ITEMS.register("black_panther_classic_mask", () -> new AddonArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CLASSIC_CHESTPLATE = ITEMS.register("black_panther_classic_chestplate", () -> new AddonArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CLASSIC_LEGGINGS = ITEMS.register("black_panther_classic_leggings", () -> new AddonArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistrySupplier<Item> CLASSIC_BOOTS = ITEMS.register("black_panther_classic_boots", () -> new AddonArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static void init() {
        CreativeModeTabRegistry.addToTab(CreativeModeTabs.FOOD_AND_DRINKS, entries -> {
                entries.addAfter(Items.SUSPICIOUS_STEW, HERB_POTION.get());
        });
        CreativeModeTabRegistry.addToTab(CreativeModeTabs.COMBAT, entries -> {
            entries.addAfter(Items.TURTLE_HELMET, CLASSIC_MASK.get(), CLASSIC_CHESTPLATE.get(), CLASSIC_LEGGINGS.get(), CLASSIC_BOOTS.get());
            entries.addAfter(CLASSIC_BOOTS.get(), CIVIL_WAR_HELMET.get(), CIVIL_WAR_CHESTPLATE.get(), CIVIL_WAR_LEGGINGS.get(), CIVIL_WAR_BOOTS.get());
            entries.addAfter(CIVIL_WAR_BOOTS.get(), NECKLACE.get());
        });
    }
}
