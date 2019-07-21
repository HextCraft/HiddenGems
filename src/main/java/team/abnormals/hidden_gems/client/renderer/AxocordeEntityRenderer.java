package team.abnormals.hidden_gems.client.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.client.entity.model.AxocordeEntityModel;
import team.abnormals.hidden_gems.entity.AxocordeEntity;

import javax.annotation.Nullable;

public class AxocordeEntityRenderer extends MobEntityRenderer<AxocordeEntity, AxocordeEntityModel<AxocordeEntity>> {

    public final Identifier TEXTURE = new Identifier(HiddenGems.MOD_ID, "textures/entity/axocorde.png");

    public AxocordeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new AxocordeEntityModel<>(), 0.4F);
    }

    @Nullable
    @Override
    protected Identifier getTexture(AxocordeEntity var1) {
        return TEXTURE;
    }

}
