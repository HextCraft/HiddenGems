package team.abnormals.hidden_gems.utils;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GuiLighting;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.util.Identifier;
import org.lwjgl.opengl.GL11;

public class TooltipRendering {

    private static final Identifier MAP_BACKGROUND = new Identifier("textures/map/map_background.png");

    public static void renderMap(ItemStack stack, int x, int y) {
        MinecraftClient client = MinecraftClient.getInstance();

        MapState mapState = FilledMapItem.getOrCreateMapState(stack, client.world);
        if (mapState == null) {
            System.out.println("This is not working");
            return;
        }

        GlStateManager.pushMatrix();
        GlStateManager.color3f(1F, 1F, 1F);
        GuiLighting.disable();
        client.getTextureManager().bindTexture(MAP_BACKGROUND);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBufferBuilder();

        int padding = 7;
        float mapSize = 135;
        float mapScale = 0.5F;

        GlStateManager.translatef(x + 43, y - mapSize * mapScale + 9, 400.0F);
        GlStateManager.scalef(mapScale, mapScale, 1.0F);

        buffer.begin(GL11.GL_QUADS, VertexFormats.POSITION_UV);
        buffer.vertex(-padding, mapSize, 0.0D).texture(0.0D, 1.0D).next();
        buffer.vertex(mapSize, mapSize, 0.0D).texture(1.0D, 1.0D).next();
        buffer.vertex(mapSize, -padding, 0.0D).texture(1.0D, 0.0D).next();
        buffer.vertex(-padding, -padding, 0.0D).texture(0.0D, 0.0D).next();
        tessellator.draw();

        drawMap(client, mapState, 1, 1, 1.0F);

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    private static void drawMap(MinecraftClient client, MapState mapState_1, int int_1, int int_2, float float_1) {
        if (mapState_1 != null) {
            GlStateManager.pushMatrix();
            GlStateManager.translatef((float) int_1, (float) int_2, 1.0F);
            GlStateManager.scalef(float_1, float_1, 1.0F);
            client.gameRenderer.getMapRenderer().draw(mapState_1, true);
            GlStateManager.popMatrix();
        }

    }

}
