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

package team.abnormals.hidden_gems.mixin.client;

import net.minecraft.client.render.entity.ParrotEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ParrotEntityRenderer.class)
public class ParrotEntityRendererMixin {

    @Shadow @Final public static Identifier[] SKINS = new Identifier[] {
            new Identifier("textures/entity/parrot/parrot_red_blue.png"),
            new Identifier("textures/entity/parrot/parrot_blue.png"),
            new Identifier("textures/entity/parrot/parrot_green.png"),
            new Identifier("textures/entity/parrot/parrot_yellow_blue.png"),
            new Identifier("textures/entity/parrot/parrot_grey.png"),
            new Identifier("textures/entity/parrot/parrot_black.png"),
            new Identifier("textures/entity/parrot/parrot_brown.png"),
            new Identifier("textures/entity/parrot/parrot_budgie.png"),
            new Identifier("textures/entity/parrot/parrot_grey.png"),
            new Identifier("textures/entity/parrot/parrot_jeb.png"),
            new Identifier("textures/entity/parrot/parrot_light_blue.png"),
            new Identifier("textures/entity/parrot/parrot_pink.png"),
            new Identifier("textures/entity/parrot/parrot_purple.png"),
            new Identifier("textures/entity/parrot/parrot_rainbow.png"),
            new Identifier("textures/entity/parrot/parrot_white.png"),
            new Identifier("textures/entity/parrot/parrot_white_bellied_caique.png"),
            new Identifier("textures/entity/parrot/parrot_yellow.png")
    };

}
