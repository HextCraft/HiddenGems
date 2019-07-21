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

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import team.abnormals.abnormalib.init.AbnormaTags;
import team.abnormals.abnormalib.utils.registry.BlockChiseler;
import team.abnormals.abnormalib.utils.registry.RegistryUtils;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.block.NeutroniaCarvedPumpkinBlock;
import team.abnormals.hidden_gems.enums.CarvedFaceTypes;

import java.util.ArrayList;
import java.util.List;

public class PumpkinInit {

    static void init() {
        List<Block> carvedPumpkins = new ArrayList<>(CarvedFaceTypes.values().length + 1);
        carvedPumpkins.add(Blocks.CARVED_PUMPKIN);
        List<Block> jackOLanterns = new ArrayList<>(CarvedFaceTypes.values().length + 1);
        jackOLanterns.add(Blocks.JACK_O_LANTERN);
        for(CarvedFaceTypes carvedFaceType : CarvedFaceTypes.values()) {
            final String name = carvedFaceType.asString();
            Block pumpkin = RegistryUtils.register(new NeutroniaCarvedPumpkinBlock(false), new Identifier(HiddenGems.MOD_ID, "carved_" + name + "_pumpkin"));
            Block lantern = RegistryUtils.register(new NeutroniaCarvedPumpkinBlock(true), new Identifier(HiddenGems.MOD_ID,  name + "_jack_o_lantern"));
            carvedPumpkins.add(pumpkin);
            jackOLanterns.add(lantern);
        }
        BlockChiseler.create(new Identifier(HiddenGems.MOD_ID, "carved_pumpkins"), AbnormaTags.SHEARS, carvedPumpkins);
        BlockChiseler.create(new Identifier(HiddenGems.MOD_ID, "jack_o_lanterns"), AbnormaTags.SHEARS, jackOLanterns);
    }

}
