package dataPackModding.api;

import com.google.gson.annotations.SerializedName;
import dataPackModding.api.entity.EntityComponents;
import net.minecraft.util.Identifier;

public class Entity {

    public Identifier identifier;
    @SerializedName("is_spawnable")
    public boolean spawnable;
    @SerializedName("is_summonable")
    public boolean summonable;
    @SerializedName("is_experimental")
    public boolean experimental;

    public int spawn_egg_color_main;
    public int spawn_egg_color_overlay;

    public EntityComponents components;

}
