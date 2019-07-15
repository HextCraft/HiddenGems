package dataPackModding.api;

import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class Block {

    public Identifier identifier;
    public String material;
    public String item_group;

    public Material getMaterial() {
        switch (material) {
            case "wood":
                return Material.WOOD;
            case "stone":
            default:
                return Material.STONE;
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
