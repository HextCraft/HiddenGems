package dataPackModding.api;

import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class Item {

    public String rarity = "common";
    public String item_group = "misc";
    public int max_count = 64;
    public Identifier identifier;
    public Identifier texture;
    public Identifier model;

    public Rarity getRarity() {
        switch (rarity) {
            case "uncommon":
                return Rarity.UNCOMMON;
            case "rare":
                return Rarity.RARE;
            case "epic":
                return Rarity.EPIC;
            case "common":
            default:
                return Rarity.COMMON;
        }
    }

    public ItemGroup getItemGroup() {
        switch (item_group) {
            case "building_blocks":
                return ItemGroup.BUILDING_BLOCKS;
            case "decorations":
                return ItemGroup.DECORATIONS;
            case "redstone":
                return ItemGroup.REDSTONE;
            case "transportation":
                return ItemGroup.TRANSPORTATION;
            case "misc":
                return ItemGroup.MISC;
            case "food":
                return ItemGroup.FOOD;
            case "tools":
                return ItemGroup.TOOLS;
            case "combat":
                return ItemGroup.COMBAT;
            case "brewing":
                return ItemGroup.BREWING;
            default:
                return null;
        }
    }

}
