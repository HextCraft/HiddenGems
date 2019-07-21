package team.abnormals.hidden_gems.client.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.client.entity.model.AntelopeModel;
import team.abnormals.hidden_gems.entity.AntelopeEntity;

import javax.annotation.Nullable;

public class AntelopeEntityRenderer extends MobEntityRenderer<AntelopeEntity, AntelopeModel<AntelopeEntity>> {

    public final Identifier TEXTURE = new Identifier(HiddenGems.MOD_ID, "textures/entity/antelope.png");

    public AntelopeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new AntelopeModel<>(), 0.4F);
    }

    @Nullable
    @Override
    protected Identifier getTexture(AntelopeEntity var1) {
        return TEXTURE;
    }

}
