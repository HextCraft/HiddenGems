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

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import team.abnormals.hidden_gems.utils.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class PointOfInterestTypeCustom {

    String id;
    private Set<BlockState> workStationStates;
    private int ticketCount;
    private SoundEvent sound;

    public PointOfInterestTypeCustom(String id, Set<BlockState> workStationStates, int ticketCount, SoundEvent sound) {
        this.id = id;
        this.workStationStates = workStationStates;
        this.ticketCount = ticketCount;
        this.sound = sound;
    }

    public static Set<BlockState> getAllStatesOf(Block block_1) {
        return ImmutableSet.copyOf(block_1.getStateFactory().getStates());
    }

    public PointOfInterestType register() {
        PointOfInterestType interestType = null;
        try {
            Constructor<PointOfInterestType> pointOfInterestType = PointOfInterestType.class.getDeclaredConstructor(String.class, Set.class, int.class, SoundEvent.class);
            pointOfInterestType.setAccessible(true);
            interestType = pointOfInterestType.newInstance(id, workStationStates, ticketCount, sound);
            Map<BlockState, PointOfInterestType> map = (Map<BlockState, PointOfInterestType>) Reflect.getMemberByType(PointOfInterestType.class, Map.class, null);
            for (BlockState blockState : workStationStates) {
                Objects.requireNonNull(map).put(blockState, interestType);
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(Objects.requireNonNull(interestType).toString());
        return interestType;
    }

}
