package team.abnormals.hidden_gems.init;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.utils.registry.RegistryUtils;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.item.BaseItem;
import team.abnormals.hidden_gems.item.FeatheredElytraItem;
import team.abnormals.hidden_gems.item.PhantomElytraItem;
import team.abnormals.hidden_gems.item.materials.CustomArmorMaterial;

public class HGItems {

    public static final Item FEATHERED_ELYTRA;
    public static final Item PHANTOM_ELYTRA;
    public static final Item RED_PHANTOM_ELYTRA;
    public static final Item ENDER_DRAGON_ELYTRA;
    public static final Item VEX_ELYTRA;
    public static final Item VEX_CHARGING_ELYTRA;
    public static final Item LIGHT_BLUE_PARROT_ELYTRA;

    public static final Item SOLARCORDE_FEATHER;
    public static final Item PHANTOM_LEATHER;
    public static final Item PHANTOM_WING;
    public static final Item GHAST_SPIRIT;
    public static final Item CHARM_OF_UNDYING;
    public static final Item OCEAN_PEARL;
    public static final Item GLOWSTONE_SHARD;
    public static final Item LARGE_HIDE;

    public static final Item PHANTOM_LEATHER_HELMET;
    public static final Item PHANTOM_LEATHER_CHESTPLATE;
    public static final Item PHANTOM_LEATHER_LEGGINGS;
    public static final Item PHANTOM_LEATHER_BOOTS;

    static {
        FEATHERED_ELYTRA = RegistryUtils.registerItem(new FeatheredElytraItem(), new Identifier(HiddenGems.MOD_ID, "feathered_elytra"));
        PHANTOM_ELYTRA = RegistryUtils.registerItem(new PhantomElytraItem(), new Identifier(HiddenGems.MOD_ID, "phantom_elytra"));
        RED_PHANTOM_ELYTRA = RegistryUtils.registerItem(new PhantomElytraItem(), new Identifier(HiddenGems.MOD_ID, "red_phantom_elytra"));
        ENDER_DRAGON_ELYTRA = RegistryUtils.registerItem(new PhantomElytraItem(), new Identifier(HiddenGems.MOD_ID, "ender_dragon_elytra"));
        VEX_ELYTRA = RegistryUtils.registerItem(new PhantomElytraItem(), new Identifier(HiddenGems.MOD_ID, "vex_elytra"));
        VEX_CHARGING_ELYTRA = RegistryUtils.registerItem(new PhantomElytraItem(), new Identifier(HiddenGems.MOD_ID, "vex_charging_elytra"));
        LIGHT_BLUE_PARROT_ELYTRA = RegistryUtils.registerItem(new PhantomElytraItem(), new Identifier(HiddenGems.MOD_ID, "light_blue_parrot_elytra"));

        SOLARCORDE_FEATHER = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "solarcorde_feather"));
        PHANTOM_LEATHER = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "phantom_leather"));
        PHANTOM_WING = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "phantom_wing"));
        GHAST_SPIRIT = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "ghast_spirit"));
        CHARM_OF_UNDYING = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "charm_of_undying"));
        OCEAN_PEARL = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "ocean_pearl"));
        GLOWSTONE_SHARD = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "glowstone_shard"));
        LARGE_HIDE = RegistryUtils.registerItem(new BaseItem(), new Identifier(HiddenGems.MOD_ID, "large_hide"));

        PHANTOM_LEATHER_HELMET = RegistryUtils.registerItem(
                new DyeableArmorItem(new CustomArmorMaterial(Ingredient.ofItems(PHANTOM_LEATHER), "phantom"),
                        EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT)), new Identifier(HiddenGems.MOD_ID, "phantom_leather_helmet")
        );
        PHANTOM_LEATHER_CHESTPLATE = RegistryUtils.registerItem(
                new DyeableArmorItem(new CustomArmorMaterial(Ingredient.ofItems(PHANTOM_LEATHER), "phantom"),
                        EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT)), new Identifier(HiddenGems.MOD_ID, "phantom_leather_chestplate")
        );
        PHANTOM_LEATHER_LEGGINGS = RegistryUtils.registerItem(
                new DyeableArmorItem(new CustomArmorMaterial(Ingredient.ofItems(PHANTOM_LEATHER), "phantom"),
                        EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT)), new Identifier(HiddenGems.MOD_ID, "phantom_leather_leggings")
        );
        PHANTOM_LEATHER_BOOTS = RegistryUtils.registerItem(
                new DyeableArmorItem(new CustomArmorMaterial(Ingredient.ofItems(PHANTOM_LEATHER), "phantom"),
                        EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT)), new Identifier(HiddenGems.MOD_ID, "phantom_leather_boots")
        );
    }

}
