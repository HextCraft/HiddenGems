package team.abnormals.hidden_gems;

import dataPackModding.DataPackModdingManager;
import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import team.abnormals.hidden_gems.block.BaseSignBlock;
import team.abnormals.hidden_gems.block.BaseWallSignBlock;
import team.abnormals.hidden_gems.config.ExampleConfig;
import team.abnormals.hidden_gems.init.*;
import team.abnormals.hidden_gems.world.CoralShelfFeature;

import java.util.HashMap;
import java.util.Map;

public class HiddenGems implements ModInitializer {

    public static final DataPackModdingManager QUEST_DATA_MANAGER = new DataPackModdingManager();
    public static String MOD_ID = "hidden_gems";
    public static String NAME = "Hidden Gems";
    public static final Logger LOGGER = LogManager.getLogger("[" + NAME + "]");
    public static String VERSION = "0.1.0";

    public static final Map<Map<BaseSignBlock, BaseWallSignBlock>, Identifier> SIGN_TEXTURES = new HashMap<>();

    @Override
    public void onInitialize() {
        AutoConfig.register(ExampleConfig.class, GsonConfigSerializer::new);

        /*File addonsDir = new File(FabricLoader.getInstance().getGameDirectory(), "addons");
        if (addonsDir.exists() && addonsDir.isDirectory()) {
            for (File file : Objects.requireNonNull(addonsDir.listFiles())) {
                if (file.getName().endsWith(".json")) {
                    try {
                        FileReader reader = new FileReader(file);
                        Gson GSON = new GsonBuilder().create().newJsonReader(reader);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            addonsDir.mkdir();
        }*/


        QUEST_DATA_MANAGER.registerReloadListener();
        LOGGER.info(String.format("You are now running %s v%s", NAME, VERSION));
        new HGBlockEntities();
        new HGBlocks();
        new HGEntities();
        new HGEnchantments();
        new HGItems();
//        new HGVillagers();
        new HGPaintingMotives();
        new PumpkinInit();
        new MelonInit();
        CoralShelfFeature.addToOceans();
    }

}