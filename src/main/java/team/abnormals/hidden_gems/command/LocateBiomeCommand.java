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

package team.abnormals.hidden_gems.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Objects;

public class LocateBiomeCommand {
    private static final SimpleCommandExceptionType FAILED_EXCEPTION = new SimpleCommandExceptionType(new LiteralText("commands.locate_biome.failed"));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> builder = CommandManager.literal("biome_find").requires((serverCommandSource_1) -> serverCommandSource_1.hasPermissionLevel(2));
        Registry.BIOME.stream().forEach(biome -> builder.then(CommandManager.literal(Objects.requireNonNull(Registry.BIOME.getId(biome)).toString()).executes(context -> execute(context.getSource(), biome))));
        dispatcher.register(builder);
    }

    private static int execute(ServerCommandSource source, Biome biome) {
        long start = System.currentTimeMillis();
        new Thread(() -> {
            BlockPos biomePos;
            try {
                ServerPlayerEntity player = source.getPlayer();
                biomePos = spiralOutwardsLookingForBiome(player, source.getWorld(), biome, source.getPlayer().getPos().getX(), source.getPlayer().getPos().getZ(), 60_000);

                if (biomePos == null) {
                    source.getMinecraftServer().execute(() -> player.sendChatMessage(new TranslatableText(Formatting.RED + "Error! Biome '" + Registry.BIOME.getId(biome) + "' could not be found after " + Formatting.GRAY + 60_000 + "ms" + Formatting.RED + "."), MessageType.GAME_INFO));
                    return;
                }
                source.getMinecraftServer().execute(() -> {
                    BlockPos blockPos_1 = new BlockPos(source.getPosition());
                    int distance = MathHelper.floor(getDistance(blockPos_1.getX(), blockPos_1.getZ(), biomePos.getX(), biomePos.getZ()));
                    Text textComponent_1 = Texts.bracketed(new TranslatableText("chat.coordinates", biomePos.getX(), "~", biomePos.getZ())).setStyle(
                            new Style().setColor(Formatting.GREEN)
                                    .setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + biomePos.getX() + " ~ " + biomePos.getZ()))
                                    .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("chat.coordinates.tooltip"))));
                    source.sendFeedback(new TranslatableText("commands.locate.success", biome, textComponent_1, distance), false);
                    player.sendChatMessage(new LiteralText(Formatting.WHITE + "Found '" + Registry.BIOME.getId(biome) + "' Biome! " + Formatting.GRAY + "(" + (System.currentTimeMillis() - start) + "ms)"), MessageType.GAME_INFO);
                });
                source.getMinecraftServer().execute(() -> player.sendChatMessage(new LiteralText(Formatting.RED + "Error! An unknown error occurred."), MessageType.GAME_INFO));
            } catch (CommandSyntaxException e) {
                e.printStackTrace();
            }
        }, "Biome Finder - Neutronia").start();

        return 1;
    }

    //Based off https://github.com/Glitchfiend/BiomesOPlenty/blob/4977b0100ca55f96de50337f46ed673512cf503a/src/main/java/biomesoplenty/common/util/biome/BiomeUtils.java
    private static BlockPos spiralOutwardsLookingForBiome(PlayerEntity player, World world, Biome biomeToFind, double startX, double startZ, int timeout) {
        double a = 16 / Math.sqrt(Math.PI);
        double b = 2 * Math.sqrt(Math.PI);
        double x;
        double z;
        double dist = 0;
        int n;
        long start = System.currentTimeMillis();
        BlockPos.PooledMutable pos = BlockPos.PooledMutable.get();
        int previous = 0;
        int i = 0;
        for (n = 0; dist < Integer.MAX_VALUE; ++n) {
            if ((System.currentTimeMillis() - start) > timeout) {
                return null;
            }
            double rootN = Math.sqrt(n);
            dist = a * rootN;
            x = startX + (dist * Math.sin(b * rootN));
            z = startZ + (dist * Math.cos(b * rootN));
            pos.set(x, 0, z);
            if (previous == 3)
                previous = 0;
            String s = (previous == 0 ? "." : previous == 1 ? ".." : "...");
            player.addChatMessage(new LiteralText("Scanning" + s), true);
            if (i == 1501) {
                previous++;
                i = 0;
            }
            i++;
            if (world.getBiome(pos).equals(biomeToFind)) {
                pos.close();
                player.addChatMessage(new LiteralText("Found Biome"), true);
                return new BlockPos((int) x, 0, (int) z);
            }
        }
        return null;
    }

    private static float getDistance(int int_1, int int_2, int int_3, int int_4) {
        int int_5 = int_3 - int_1;
        int int_6 = int_4 - int_2;
        return MathHelper.sqrt((float) (int_5 * int_5 + int_6 * int_6));
    }
}