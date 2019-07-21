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

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.item.Items;
import net.minecraft.item.map.MapIcon;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import team.abnormals.hidden_gems.village.TradeOfferFactories.*;

import java.util.Random;

class TradeBuilder {
    private static final Logger LOGGER = LogManager.getLogger();

    static void createRecipes() {

        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(HGVillagers.ARTIST, copyToFastUtilMap(
                ImmutableMap.of(
                        1, new TradeOffers.Factory[]{
                                new BuyItemFactory(Items.RED_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.GREEN_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.PURPLE_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.CYAN_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.LIGHT_GRAY_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.GRAY_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.PINK_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.LIME_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.YELLOW_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.LIGHT_BLUE_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.MAGENTA_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.ORANGE_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.BLUE_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.BROWN_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.BLACK_DYE, 18, 22, 2),
                                new BuyItemFactory(Items.WHITE_DYE, 18, 22, 2),
                        },
                        2, new TradeOffers.Factory[]{
                                new SellItemFactory(Items.WHITE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.BLUE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.RED_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.PINK_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.GREEN_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.LIME_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.GRAY_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.BLACK_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.PURPLE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.CYAN_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.BROWN_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.YELLOW_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.ORANGE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 15)
                        }
                )
        ));

        /*TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(NVillagers.ICE_CARVER, copyToFastUtilMap(
                ImmutableMap.of(1,
                        new TradeOffers.Factory[]{
                                new BuyForOneEmeraldFactory(new ItemStack(Blocks.ICE, 4).getItem(), 1, 8, 2),
                                new BuyForOneEmeraldFactory(new ItemStack(Items.PACKED_ICE, 9).getItem(), 4, 1, 1)
                        },
                        2, new TradeOffers.Factory[]{
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 2), new ItemStack(Blocks.BLUE_ICE, 1), new ItemStack(NBlocks.PACKED_ICE_BRICKS, 4), 8, 10),
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 2), new ItemStack(Blocks.PACKED_ICE), new ItemStack(NBlocks.PACKED_ICE_PILLAR, 2), 6, 5)
                        },
                        3, new TradeOffers.Factory[]{
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 5), new ItemStack(Blocks.ICE, 10), new ItemStack(NBlocks.ICE_LANTERN), 6, 20),
                        },
                        4, new TradeOffers.Factory[]{
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 3), new ItemStack(Blocks.GLASS_PANE, 12), new ItemStack(NBlocks.FROSTED_GLASS_PANE, 12), 1, 15),
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 2), new ItemStack(Blocks.BLUE_ICE, 5), new ItemStack(NBlocks.ICE_DOOR), 1, 15),
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 2), new ItemStack(Blocks.PACKED_ICE, 5), new ItemStack(NBlocks.ICE_TRAPDOOR), 1, 15)
                        },
                        5, new TradeOffers.Factory[]{
                                new TwoItemsForOneItemFactory(new ItemStack(Items.EMERALD, 16), new ItemStack(Blocks.ICE, 24), new ItemStack(NBlocks.ICE_SAW, 1), 1, 30)
                        }
                )
        ));*/

        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.CARTOGRAPHER, copyToFastUtilMap(
                ImmutableMap.of(1,
                        new TradeOffers.Factory[]{
                                new BuyForOneEmeraldFactory(Items.PAPER, 24, 8, 2),
                                new SellItemFactory(Items.MAP, 7, 1, 1)
                        },
                        2, new TradeOffers.Factory[]{
                                new BuyForOneEmeraldFactory(Items.GLASS_PANE, 10, 8, 10),
                                new SellMapFactory(13, "Monument", MapIcon.Type.MONUMENT, 6, 5)
                        },
                        3, new TradeOffers.Factory[]{
                                new BuyForOneEmeraldFactory(Items.COMPASS, 1, 6, 20),
                                new SellMapFactory(14, "Mansion", MapIcon.Type.MANSION, 6, 10)
                        },
                        4, new TradeOffers.Factory[]{
                                new SellItemFactory(Items.ITEM_FRAME, 7, 1, 15),
                                new SellItemFactory(Items.WHITE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.BLUE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.LIGHT_BLUE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.RED_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.PINK_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.GREEN_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.LIME_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.GRAY_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.BLACK_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.PURPLE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.MAGENTA_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.CYAN_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.BROWN_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.YELLOW_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.ORANGE_BANNER, 3, 1, 15),
                                new SellItemFactory(Items.LIGHT_GRAY_BANNER, 3, 1, 15)
                        },
                        5, new TradeOffers.Factory[]{
                                new SellItemFactory(Items.GLOBE_BANNER_PATTERN, 8, 1, 30)
                        }
                )
        ));

        TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.FISHERMAN).merge(1, new TradeOffers.Factory[]{
                new TypeAwareBuyItemFactory(ImmutableMap.of(VillagerType.SNOW, Items.SNOW, VillagerType.DESERT, Items.BONE), 10, 22, 2)
        }, ArrayUtils::addAll);

        /*TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(NVillagers.RECEPTIONIST, copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{
                new BuyItemFactory(Items.BOOK, 18, 22, 2)
        })));*/

        /*TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(CARPENTER, copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{
                new BuyItemFactory(Blocks.ACACIA_PLANKS, 18, 22, 2),
                new BuyItemFactory(Blocks.BIRCH_PLANKS, 18, 22, 2),
                new BuyItemFactory(Blocks.DARK_OAK_PLANKS, 18, 22, 2),
                new BuyItemFactory(Blocks.JUNGLE_PLANKS, 18, 22, 2),
                new BuyItemFactory(Blocks.OAK_PLANKS, 18, 22, 2),
                new BuyItemFactory(Blocks.SPRUCE_PLANKS, 18, 22, 2),

                new BuyItemFactory(Blocks.ACACIA_STAIRS, 18, 22, 2),
                new BuyItemFactory(Blocks.BIRCH_STAIRS, 18, 22, 2),
                new BuyItemFactory(Blocks.DARK_OAK_STAIRS, 18, 22, 2),
                new BuyItemFactory(Blocks.JUNGLE_STAIRS, 18, 22, 2),
                new BuyItemFactory(Blocks.OAK_STAIRS, 18, 22, 2),
                new BuyItemFactory(Blocks.SPRUCE_STAIRS, 18, 22, 2),

                new BuyItemFactory(Blocks.ACACIA_SLAB, 18, 22, 2),
                new BuyItemFactory(Blocks.BIRCH_SLAB, 18, 22, 2),
                new BuyItemFactory(Blocks.DARK_OAK_SLAB, 18, 22, 2),
                new BuyItemFactory(Blocks.JUNGLE_SLAB, 18, 22, 2),
                new BuyItemFactory(Blocks.OAK_SLAB, 18, 22, 2),
                new BuyItemFactory(Blocks.SPRUCE_SLAB, 18, 22, 2),

                new BuyItemFactory(Blocks.ACACIA_LOG, 18, 22, 2),
                new BuyItemFactory(Blocks.BIRCH_LOG, 18, 22, 2),
                new BuyItemFactory(Blocks.DARK_OAK_LOG, 18, 22, 2),
                new BuyItemFactory(Blocks.JUNGLE_LOG, 18, 22, 2),
                new BuyItemFactory(Blocks.OAK_LOG, 18, 22, 2),
                new BuyItemFactory(Blocks.SPRUCE_LOG, 18, 22, 2)
        })));*/
    }

    private static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap_1) {
        return new Int2ObjectOpenHashMap<>(immutableMap_1);
    }

    static class PriceRange {
        final int lower;
        final int range;

        PriceRange(int int_1, int int_2) {
            this.lower = int_1;
            this.range = 1 + Math.max(0, int_2 - int_1);
            if (int_2 < int_1) {
                LOGGER.warn("PriceRange({}, {}) invalid, {} smaller than {}", int_1, int_2, int_2, int_1);
            }

        }

        int getPrice(Random random_1) {
            return this.lower + random_1.nextInt(this.range);
        }
    }

}