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

package team.abnormals.hidden_gems.village;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;
import team.abnormals.hidden_gems.HiddenGems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public interface VillagerTypeRegistry {
    HashMap<Biome, ArrayList<VillagerType>> customVillagerTypes = new HashMap<>();

    static VillagerType register(String string_1, Biome... biomes) {
        VillagerType villagerType = Registry.register(Registry.VILLAGER_TYPE, new Identifier(HiddenGems.MOD_ID, string_1), new net.minecraft.village.VillagerType() {
            public String toString() {
                return string_1;
            }
        });
        for (Biome biome : biomes) {
            if (customVillagerTypes.containsKey(biome))
                customVillagerTypes.get(biome).add(villagerType);
            else {
                customVillagerTypes.put(biome, new ArrayList<>(Collections.singleton(villagerType)));
            }
        }
        return villagerType;
    }

    static VillagerType getVillagerTypeForBiome(Biome biome) {
        if (customVillagerTypes.containsKey(biome)) {
            ArrayList<VillagerType> villagerTypes = customVillagerTypes.get(biome);
            return villagerTypes.get(MathHelper.floor(villagerTypes.size() * Math.random()));
        } else {
            return VillagerType.forBiome(biome);
        }
    }
}