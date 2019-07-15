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

package team.abnormals.hidden_gems.mixin.client.screen;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin() {
        super(new TranslatableText("narrator.screen.title"));
    }

    @Inject(method = "render(IIF)V", at = @At("RETURN"))
    public void fabricInfo(int mouseX, int mouseY, float delta, CallbackInfo info) {
        this.minecraft.textRenderer.draw("Fabric Loader: v" + FabricLoader.getInstance().getModContainer("fabricloader").orElseThrow(null).getMetadata().getVersion(),
                2, this.height - 40, 0xFFFFFF);
        this.minecraft.textRenderer.draw("Fabric API: v" + FabricLoader.getInstance().getModContainer("fabric").orElseThrow(null).getMetadata().getVersion(),
                2, this.height - 30, 0xFFFFFF);
        this.minecraft.textRenderer.draw("Loaded mods: " + FabricLoader.getInstance().getAllMods().size(), 2, this.height - 20,
                0xFFFFFF);
    }

}