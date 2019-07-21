package team.abnormals.hidden_gems.init;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.block.sapling.OakSaplingGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.abnormals.abnormalib.blocks.FlowerPotBaseBlock;
import team.abnormals.abnormalib.utils.registry.BlockRegistryBuilder;
import team.abnormals.abnormalib.utils.registry.RegistryUtils;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.block.*;
import team.abnormals.hidden_gems.utils.WoodRegistry;
import team.abnormals.hidden_gems.utils.enums.WoodType;

import java.util.HashMap;
import java.util.Map;

public class HGBlocks {

    public static Block[] CAMPFIRES = new Block[WoodType.VANILLA_WOODS.size()];
    public static Block[] BOOKSHELVES = new Block[WoodType.VANILLA_WOODS.size()];
    public static Block[] LECTERNS = new Block[WoodType.VANILLA_WOODS.size()];

    /*public static final Block STICK_BUNDLE, CHORUS_BUNDLE, SUGAR_CANE_BUNDLE, BAMBOO_BUNDLE, UNCUT_BAMBOO_BUNDLE, NETHER_WART_SACK, COCOA_BEAN_SACK, GUNPOWDER_SACK,
            EGG_CRATE, BEETROOT_CRATE, POTATO_CRATE, CARROT_CRATE, APPLE_CRATE, GOLDEN_APPLE_CRATE, CACTUS_BUNDLE;
    public static final Block BAMBOO_PLANKS, BAMBOO_TORCH, THATCH, TIKI_TORCH;*/
    public static final BaseSignBlock BAMBOO_SIGN;
    public static final BaseWallSignBlock BAMBOO_WALL_SIGN;
    public static final Block ROPE;
    public static final Block GRATE, IRON_GRATE, GOLDEN_GRATE;

    public static final Block POTTED_BEETROOT, POTTED_CARROTS, POTTED_CHORUS, POTTED_GRASS, POTTED_LILAC, POTTED_MELON, POTTED_NETHER_WART, POTTED_PEONY,
            POTTED_POTATOES, POTTED_PUMPKIN, POTTED_ROSE_BUSH, POTTED_SUGAR_CANE, POTTED_SUNFLOWER, POTTED_TALL_GRASS, POTTED_LARGE_FERN, POTTED_WHEAT;
    
    private static String MOD_ID = HiddenGems.MOD_ID;

    static {
        for (WoodType woodType : WoodType.VANILLA_WOODS) {
            if (woodType == WoodType.OAK) continue;
            BOOKSHELVES[woodType.getIndex()] = RegistryUtils.register(new Block(Block.Settings.of(Material.WOOD)), new Identifier(MOD_ID, String.format("%s_bookshelf", woodType.asString())), ItemGroup.BUILDING_BLOCKS);
            CAMPFIRES[woodType.getIndex()] = RegistryUtils.register(new CampfireBlock(woodType, FabricBlockSettings.of(Material.WOOD, MaterialColor.SPRUCE).hardness(2.0F)
                    .sounds(BlockSoundGroup.WOOD).lightLevel(15).ticksRandomly().build()), new Identifier(MOD_ID, String.format("%s_campfire", woodType.asString())));
            LECTERNS[woodType.getIndex()] = RegistryUtils.register(new BaseLecternBlock(woodType), new Identifier(MOD_ID, String.format("%s_lectern",
                    woodType.asString())), ItemGroup.REDSTONE);
        }

        BlockRegistryBuilder.getInstance(new Identifier(MOD_ID, "cracked_stone_brick"), Blocks.CRACKED_STONE_BRICKS).wall().stair().slab();

        ROPE = RegistryUtils.register(new RopeBlock(), new Identifier(HiddenGems.MOD_ID, "rope"), ItemGroup.DECORATIONS);

        GRATE = RegistryUtils.register(new GrateBlock(), new Identifier(MOD_ID, "grate"), ItemGroup.DECORATIONS);
        IRON_GRATE = RegistryUtils.register(new GrateBlock(), new Identifier(MOD_ID, "iron_grate"), ItemGroup.DECORATIONS);
        GOLDEN_GRATE = RegistryUtils.register(new GrateBlock(), new Identifier(MOD_ID, "golden_grate"), ItemGroup.DECORATIONS);

        new WoodRegistry.Builder(new Identifier(MOD_ID, "blossom"), new OakSaplingGenerator())
                .planks().sapling().log().leaves("pink_blossom").leaves("white_blossom")
                .leaves("purple_blossom").strippedLog().wood().strippedWood().stairs().slab()
                .bookshelf().paperLantern().carvedPlanks().build();

        /*STICK_BUNDLE = RegistryUtils.register(new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "stick_bundle");
        CHORUS_BUNDLE = RegistryUtils.register(new PillarBlock(FabricBlockSettings.of(Material.ORGANIC).sounds(BlockSoundGroup.CROP).build()), "chorus_fruit_bundle");
        SUGAR_CANE_BUNDLE = RegistryUtils.register(new PillarBlock(FabricBlockSettings.of(Material.ORGANIC).sounds(BlockSoundGroup.CROP).build()), "sugar_cane_bundle");
        BAMBOO_BUNDLE = RegistryUtils.register(new PillarBlock(FabricBlockSettings.of(Material.BAMBOO).sounds(BlockSoundGroup.BAMBOO).build()), "bamboo_bundle");
        UNCUT_BAMBOO_BUNDLE = RegistryUtils.register(new PillarBlock(FabricBlockSettings.of(Material.BAMBOO).sounds(BlockSoundGroup.BAMBOO).build()), "bamboo_bundle");
        CACTUS_BUNDLE = new CactusBundleBlock();

        NETHER_WART_SACK = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOL).sounds(BlockSoundGroup.WOOL).build()), "nether_wart_sack");
        COCOA_BEAN_SACK = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOL).sounds(BlockSoundGroup.WOOL).build()), "cocoa_beans_sack");
        GUNPOWDER_SACK = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOL).sounds(BlockSoundGroup.WOOL).build()), "gunpowder_sack");

        EGG_CRATE = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "egg_crate");
        BEETROOT_CRATE = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "beetroot_crate");
        POTATO_CRATE = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "potato_crate");
        CARROT_CRATE = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "carrot_crate");
        APPLE_CRATE = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "apple_crate");
        GOLDEN_APPLE_CRATE = RegistryUtils.register(new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).build()), "golden_apple_crate");*/

        /*BAMBOO_PLANKS = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), new Identifier(MOD_ID, "bamboo_planks"));
        BlockRegistryBuilder.getInstance(new Identifier(MOD_ID, "bamboo"), BAMBOO_PLANKS).slab().stair().fence().fenceGate();*/
        BAMBOO_SIGN = new BaseSignBlock(FabricBlockSettings.of(Material.WOOD).noCollision().hardness(1.0F).sounds(BlockSoundGroup.WOOD).build());
        BAMBOO_WALL_SIGN = new BaseWallSignBlock(FabricBlockSettings.of(Material.WOOD).noCollision().hardness(1.0F).sounds(BlockSoundGroup.WOOD).build());
        registerSign(BAMBOO_SIGN, new Identifier(MOD_ID, "bamboo_sign"), BAMBOO_WALL_SIGN, new Identifier(MOD_ID, "bamboo_wall_sign"), new Identifier(MOD_ID, "textures/entity/signs/bamboo.png"));
        /*THATCH = RegistryUtils.register(new Block(Block.Settings.copy(Blocks.HAY_BLOCK)), new Identifier(MOD_ID, "thatch"));
        BlockRegistryBuilder.getInstance(new Identifier(MOD_ID, "thatch"), THATCH).slab().stair();*/

        POTTED_BEETROOT = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.BEETROOTS), new Identifier(MOD_ID, "potted_beetroot"));
        POTTED_CARROTS = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.CARROTS), new Identifier(MOD_ID, "potted_carrots"));
        POTTED_CHORUS = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.CHORUS_FLOWER), new Identifier(MOD_ID, "potted_chorus"));
        POTTED_GRASS = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.GRASS), new Identifier(MOD_ID, "potted_grass"));
        POTTED_LILAC = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.LILAC), new Identifier(MOD_ID, "potted_lilac"));
        POTTED_MELON = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.MELON), new Identifier(MOD_ID, "potted_melon"));
        POTTED_NETHER_WART = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.NETHER_WART), new Identifier(MOD_ID, "potted_nether_wart"));
        POTTED_PEONY = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.PEONY), new Identifier(MOD_ID, "potted_peony"));
        POTTED_POTATOES = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.POTATOES), new Identifier(MOD_ID, "potted_potatoes"));
        POTTED_PUMPKIN = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.PUMPKIN), new Identifier(MOD_ID, "potted_pumpkin"));
        POTTED_ROSE_BUSH = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.ROSE_BUSH), new Identifier(MOD_ID, "potted_rose_bush"));
        POTTED_SUGAR_CANE = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.SUGAR_CANE), new Identifier(MOD_ID, "potted_sugar_cane"));
        POTTED_SUNFLOWER = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.SUNFLOWER), new Identifier(MOD_ID, "potted_sunflower"));
        POTTED_TALL_GRASS = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.TALL_GRASS), new Identifier(MOD_ID, "potted_tall_grass"));
        POTTED_LARGE_FERN = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.LARGE_FERN), new Identifier(MOD_ID, "potted_large_fern"));
        POTTED_WHEAT = RegistryUtils.registerBlockWithoutItem(new FlowerPotBaseBlock(Blocks.WHEAT), new Identifier(MOD_ID, "potted_wheat"));
    }

    private static void registerSign(BaseSignBlock signBlock, Identifier signName, BaseWallSignBlock wallSignBlock, Identifier wallSignName, Identifier texture) {
        Map<BaseSignBlock, BaseWallSignBlock> SIGN_BLOCKS = new HashMap<>();
        SIGN_BLOCKS.put(signBlock, wallSignBlock);
        SIGN_BLOCKS.forEach((signBlock1, wallSignBlock1) -> {
            RegistryUtils.registerBlockWithoutItem(signBlock1, signName);
            RegistryUtils.registerBlockWithoutItem(wallSignBlock1, wallSignName);
            RegistryUtils.registerItem(new SignItem((new Item.Settings()).maxCount(16).group(ItemGroup.DECORATIONS), signBlock1, wallSignBlock1), signName);
            Registry.register(Registry.BLOCK_ENTITY, new Identifier(HiddenGems.MOD_ID, signName.getPath() + "_be"),
                    BlockEntityType.Builder.create(SignBlockEntity::new, signBlock1, wallSignBlock1).build(null));
        });
        HiddenGems.SIGN_TEXTURES.put(SIGN_BLOCKS, texture);
    }

}