//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package team.abnormals.hidden_gems.client.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.util.Identifier;
import team.abnormals.hidden_gems.block.BaseLecternBlock;
import team.abnormals.hidden_gems.block.entity.LecternBlockEntity;

@Environment(EnvType.CLIENT)
public class LecternBlockEntityRenderer extends BlockEntityRenderer<LecternBlockEntity> {
    private static final Identifier BOOK_TEXTURE = new Identifier("textures/entity/enchanting_table_book.png");
    private final BookModel book = new BookModel();

    public LecternBlockEntityRenderer() {
    }

    public void method_17582(LecternBlockEntity lecternBlockEntity_1, double double_1, double double_2, double double_3, float float_1, int int_1) {
        BlockState blockState_1 = lecternBlockEntity_1.getCachedState();
        if (blockState_1.get(BaseLecternBlock.HAS_BOOK)) {
            GlStateManager.pushMatrix();
            GlStateManager.translatef((float) double_1 + 0.5F, (float) double_2 + 1.0F + 0.0625F, (float) double_3 + 0.5F);
            float float_2 = blockState_1.get(BaseLecternBlock.FACING).rotateYClockwise().asRotation();
            GlStateManager.rotatef(-float_2, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotatef(67.5F, 0.0F, 0.0F, 1.0F);
            GlStateManager.translatef(0.0F, -0.125F, 0.0F);
            this.bindTexture(BOOK_TEXTURE);
            GlStateManager.enableCull();
            this.book.render(0.0F, 0.1F, 0.9F, 1.2F, 0.0F, 0.0625F);
            GlStateManager.popMatrix();
        }
    }
}
