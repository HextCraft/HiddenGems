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

package team.abnormals.hidden_gems.utils;

import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.resource.ClientResourcePackContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import team.abnormals.hidden_gems.entity.FlyingLanternEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {

    private static int availableProcessors = Runtime.getRuntime().availableProcessors();

    public static ItemStack dispense(BlockPointer blockPointer, ItemStack itemStack) {
        Direction direction = blockPointer.getBlockState().get(DispenserBlock.FACING);
        Position output = DispenserBlock.getOutputLocation(blockPointer);

        FlyingLanternEntity entity = FlyingLanternEntity.create(blockPointer.getWorld(), output.getX(), output.getY(), output.getZ(), Block.getBlockFromItem(itemStack.getItem()).getDefaultState());
        entity.setVelocity(direction.getOffsetX() * 0.03, 0, direction.getOffsetZ() * 0.03);
        blockPointer.getWorld().spawnEntity(entity);

        itemStack.decrement(1);
        return itemStack;
    }

    public static int getAvailableProcessors() {
        return availableProcessors;
    }

    public static boolean isSingleProcessor() {
        return getAvailableProcessors() <= 1;
    }

    public static int parseInt(String str, final int defVal) {
        try {
            if (str == null) {
                return defVal;
            }
            str = str.trim();
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            return defVal;
        }
    }

    public static boolean parseBoolean(String str, final boolean defVal) {
        try {
            if (str == null) {
                return defVal;
            }
            str = str.trim();
            return Boolean.parseBoolean(str);
        }
        catch (NumberFormatException e) {
            return defVal;
        }
    }

    public static Boolean parseBoolean(String str, final Boolean defVal) {
        try {
            if (str == null) {
                return defVal;
            }
            str = str.trim().toLowerCase();
            if (str.equals("true")) {
                return Boolean.TRUE;
            }
            if (str.equals("false")) {
                return Boolean.FALSE;
            }
            return defVal;
        }
        catch (NumberFormatException e) {
            return defVal;
        }
    }

    public static ResourcePack[] getResourcePacks() {
        final ResourcePackContainerManager<ClientResourcePackContainer> rep = (ResourcePackContainerManager<ClientResourcePackContainer>) MinecraftClient.getInstance().getResourceManager();
        final Collection<ClientResourcePackContainer> packInfos = rep.getEnabledContainers();
        final List<ResourcePack> list = new ArrayList<>();
        for (final ClientResourcePackContainer rpic : packInfos) {
            final ResourcePack rp = rpic.createResourcePack();
            if (rp == getDefaultResourcePack()) {
                continue;
            }
            list.add(rp);
        }
        final ResourcePack[] rps = list.toArray(new ResourcePack[list.size()]);
        return rps;
    }

    public static ResourcePack getDefaultResourcePack() {
        return MinecraftClient.getInstance().getResourcePackDownloader().getPack();
    }

    public static String arrayToString(final Object[] arr) {
        return arrayToString(arr, ", ");
    }

    public static String arrayToString(final Object[] arr, final String separator) {
        if (arr == null) {
            return "";
        }
        final StringBuilder buf = new StringBuilder(arr.length * 5);
        for (int i = 0; i < arr.length; ++i) {
            final Object obj = arr[i];
            if (i > 0) {
                buf.append(separator);
            }
            buf.append(obj);
        }
        return buf.toString();
    }

    public static String arrayToString(final int[] arr) {
        return arrayToString(arr, ", ");
    }

    public static String arrayToString(final int[] arr, final String separator) {
        if (arr == null) {
            return "";
        }
        final StringBuffer buf = new StringBuffer(arr.length * 5);
        for (int i = 0; i < arr.length; ++i) {
            final int x = arr[i];
            if (i > 0) {
                buf.append(separator);
            }
            buf.append(x);
        }
        return buf.toString();
    }

    public static String arrayToString(final float[] arr) {
        return arrayToString(arr, ", ");
    }

    public static String arrayToString(final float[] arr, final String separator) {
        if (arr == null) {
            return "";
        }
        final StringBuffer buf = new StringBuffer(arr.length * 5);
        for (int i = 0; i < arr.length; ++i) {
            final float x = arr[i];
            if (i > 0) {
                buf.append(separator);
            }
            buf.append(x);
        }
        return buf.toString();
    }

    public static boolean hasResource(final Identifier location) {
        if (location == null) {
            return false;
        }
        final ResourcePack rp = getDefiningResourcePack(location);
        return rp != null;
    }

    public static boolean hasResource(final ResourceManager resourceManager, final Identifier location) {
        try {
            final Resource res = resourceManager.getResource(location);
            return res != null;
        }
        catch (IOException e) {
            return false;
        }
    }

    public static boolean hasResource(final ResourcePack rp, final Identifier loc) {
        return rp != null && loc != null && rp.contains(ResourceType.CLIENT_RESOURCES, loc);
    }

    public static ResourcePack getDefiningResourcePack(final Identifier location) {
        final ResourcePackContainerManager<ClientResourcePackContainer> rep = MinecraftClient.getInstance().getResourcePackContainerManager();
        final Collection<ClientResourcePackContainer> packInfos = rep.getEnabledContainers();
        final List<ClientResourcePackContainer> entries = (List<ClientResourcePackContainer>)packInfos;
        for (int i = entries.size() - 1; i >= 0; --i) {
            final ClientResourcePackContainer entry = entries.get(i);
            final ResourcePack rp = entry.createResourcePack();
            if (rp.contains(ResourceType.CLIENT_RESOURCES, location)) {
                return rp;
            }
        }
        return null;
    }

}
