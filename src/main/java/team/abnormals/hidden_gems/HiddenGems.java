package team.abnormals.hidden_gems;

import dataPackModding.DataPackModdingManager;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import team.abnormals.hidden_gems.init.HGBlockEntities;
import team.abnormals.hidden_gems.init.HGBlocks;

public class HiddenGems implements ModInitializer {

    public static String MOD_ID = "hidden_gems";
    public static String NAME = "Hidden Gems";
    public static String VERSION = "0.1.0";

    public static final Logger LOGGER = LogManager.getLogger("[" + NAME + "]");
    public static final DataPackModdingManager QUEST_DATA_MANAGER = new DataPackModdingManager();

    @Override
    public void onInitialize() {
        QUEST_DATA_MANAGER.registerReloadListener();
        LOGGER.info(String.format("You are now running %s v%s", NAME, VERSION));

        new HGBlockEntities();
        new HGBlocks();
    }

}