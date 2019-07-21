/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Team Abnormals
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package team.abnormals.hidden_gems.init;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.abnormals.hidden_gems.HiddenGems;

public class HGPaintingMotives {

    //Original paintings
    public static final PaintingMotive A_CRUEL_FORTRESS = register("a_cruel_fortress", 32, 32);
    public static final PaintingMotive ALEX = register("alex", 16, 16);
    public static final PaintingMotive BLAZING_HAIR = register("blazing_hair", 48, 48);
    public static final PaintingMotive BLAZING_SILHOUETTE = register("blazing_silhouette", 48, 48);
    public static final PaintingMotive BLUE = register("blue", 16, 16);
    public static final PaintingMotive CAKE = register("cake", 16, 16);
    public static final PaintingMotive CLUCKER = register("clucker", 16, 16);
    public static final PaintingMotive COOKIE = register("cookie", 16, 16);
    public static final PaintingMotive DIAMOND = register("diamond", 32, 16);
    public static final PaintingMotive DANGER = register("danger", 32, 32);
    public static final PaintingMotive ECHOLOCATION = register("echolocation", 32, 32);
    public static final PaintingMotive END_ISLAND = register("end_island", 16, 16);
    public static final PaintingMotive ENDER_DRAGON = register("ender_dragon", 16, 32);
    public static final PaintingMotive ENDER_THING = register("ender_thing", 32, 16);
    public static final PaintingMotive FLAT_EARTH = register("flat_earth", 48, 32);
    public static final PaintingMotive GLOOP = register("gloop", 16, 16);
    public static final PaintingMotive GOLEMTRY = register("golemtry", 32, 32);
    public static final PaintingMotive GUARDIAN = register("guardian", 48, 32);
    public static final PaintingMotive GUARDIAN_ALT = register("guardian_alt", 48, 32);
    public static final PaintingMotive GUARDIAN_BLUEPRINT = register("guardian_blueprint", 32, 32);
    public static final PaintingMotive GUARDIAN_CYCLOPS = register("guardian_cyclops", 16, 16);
    public static final PaintingMotive GUARDIAN_SMITHING = register("guardian_smithing", 32, 32);
    public static final PaintingMotive HIEROGLYPHS = register("hieroglyphs", 32, 32);
    public static final PaintingMotive ISLANDS = register("islands", 16, 32);
    public static final PaintingMotive JAPANESE_PAINTING = register("japanese_painting", 16, 16);
    public static final PaintingMotive KILL_OR_BE_KILLED = register("kill_or_be_killed", 32, 16);
    public static final PaintingMotive LAYERED_WORLD = register("layered_world", 32, 32);
    public static final PaintingMotive MCA = register("mca", 32, 32);
    public static final PaintingMotive MOUNTAIN_CLOUDS = register("mountain_clouds", 64, 32);
    public static final PaintingMotive NETHER_NIGHTMARE = register("nether_nightmare", 32, 32);
    public static final PaintingMotive PIXEL_STUDIO = register("pixel_studio", 32, 32);
    public static final PaintingMotive REUBEN = register("reuben", 32, 32);
    public static final PaintingMotive SAVANNA_SUNRISE = register("savanna_sunrise", 16, 32);
    public static final PaintingMotive SAVANNA_SUNSET = register("savanna_sunset", 48, 16);
    public static final PaintingMotive SHULKER = register("shulker", 32, 32);
    public static final PaintingMotive SLAM_A_COW = register("slam_a_cow", 16, 16);
    public static final PaintingMotive SLIME = register("slime", 16, 16);
    public static final PaintingMotive SO_YOU_THINK_YOU_COUL_FIGHT_A_GOD = register("so_you_think_you_can_fight_a_god", 128, 80);
    public static final PaintingMotive STEVE = register("steve", 16, 16);
    public static final PaintingMotive STICK_BY_ME = register("stick_by_me", 32, 32);
    public static final PaintingMotive SUPRISE = register("suprise", 16, 32);
    public static final PaintingMotive SWIPER = register("swiper", 16, 16);
    public static final PaintingMotive TAIGA_LAKE = register("taiga_lake", 16, 16);
    public static final PaintingMotive THE_DEVIL_BELOW = register("the_devil_below", 32, 32);
    public static final PaintingMotive THE_DRAGON = register("the_dragon", 32, 32);
    public static final PaintingMotive THE_END = register("the_end", 32, 16);
    public static final PaintingMotive THE_NETHER = register("the_nether", 32, 32);
    public static final PaintingMotive WATERFALL = register("waterfall", 32, 32);
    public static final PaintingMotive WILLOW_TREE = register("willow_tree", 16, 16);
    public static final PaintingMotive WINTER_WONDERLAND = register("winter_wonderland", 32, 16);
    public static final PaintingMotive WISPY_MEADOW = register("wispy_meadow", 32, 32);
    public static final PaintingMotive X_MARKS_THE_SPOT = register("x_marks_the_spot", 32, 32);

    private static PaintingMotive register(String string_1, int width, int textureY) {
        return Registry.register(Registry.MOTIVE, new Identifier(HiddenGems.MOD_ID, string_1), new PaintingMotive(width, textureY));
    }

}