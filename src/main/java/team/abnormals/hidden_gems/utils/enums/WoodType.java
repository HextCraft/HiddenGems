package team.abnormals.hidden_gems.utils.enums;

import net.minecraft.util.StringIdentifiable;

import java.util.*;

public class WoodType implements StringIdentifiable {

    public static final WoodType OAK = new WoodType(0, "oak");
    public static final WoodType SPRUCE = new WoodType(1, "spruce");
    public static final WoodType BIRCH = new WoodType(2, "birch");
    public static final WoodType JUNGLE = new WoodType(3, "jungle");
    public static final WoodType ACACIA = new WoodType(4, "acacia");
    public static final WoodType DARK_OAK = new WoodType(5, "dark_oak");

    public static final Set<WoodType> VANILLA_WOODS = new HashSet<>(Arrays.asList(OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK));
    private static List<WoodType> WOOD_TYPES = new ArrayList<>();

    private final int index;
    private final String name;

    public WoodType(int metaIn, String name) {
        this.index = metaIn;
        this.name = name;
//        WOOD_TYPES.add(new WoodType(metaIn, name));
    }

    public static int nextInt() {
        return WOOD_TYPES.size() + 1;
    }

    public int getIndex() {
        return this.index;
    }

    public String asString() {
        return this.name;
    }

}