package team.abnormals.hidden_gems.config;

import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import team.abnormals.hidden_gems.HiddenGems;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public String getModId() {
        return HiddenGems.MOD_ID;
    }

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return screen -> AutoConfig.getConfigScreen(ExampleConfig.class, screen).get();
    }

}
