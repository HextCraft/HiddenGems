package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelAxolotlTopHat - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelAxolotlTopHat extends EntityModel {
    public Cuboid TopHat1;
    public Cuboid TopHat2;

    public ModelAxolotlTopHat() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.TopHat2 = new Cuboid(this, 0, 4);
        this.TopHat2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopHat2.addBox(-1.0F, -3.5F, -1.0F, 2, 3, 2, 0.0F);
        this.TopHat1 = new Cuboid(this, 0, 0);
        this.TopHat1.setRotationPoint(-2.0F, 19.5F, -6.0F);
        this.TopHat1.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(TopHat1, 0.0F, 0.0F, -0.4363323129985824F);
        this.TopHat1.addChild(this.TopHat2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.TopHat1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(Cuboid modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }
}
