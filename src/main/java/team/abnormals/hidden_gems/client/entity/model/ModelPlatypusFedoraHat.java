package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelPlatypusFedoraHat - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelPlatypusFedoraHat extends EntityModel {
    public Cuboid Hat1;
    public Cuboid Hat2;
    public Cuboid Hat3;
    public Cuboid Hat4;

    public ModelPlatypusFedoraHat() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Hat3 = new Cuboid(this, 40, 0);
        this.Hat3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat3.addBox(-2.0F, -3.5F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(Hat3, -0.17453292519943295F, 0.0F, 0.0F);
        this.Hat2 = new Cuboid(this, 24, 0);
        this.Hat2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat2.addBox(-2.0F, -2.5F, -2.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(Hat2, -0.17453292519943295F, 0.0F, 0.0F);
        this.Hat4 = new Cuboid(this, 54, 0);
        this.Hat4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat4.addBox(1.0F, -3.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Hat4, -0.17453292519943295F, 0.0F, 0.0F);
        this.Hat1 = new Cuboid(this, 0, 0);
        this.Hat1.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.Hat1.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F);
        this.setRotateAngle(Hat1, 0.17453292519943295F, 0.0F, 0.0F);
        this.Hat1.addChild(this.Hat3);
        this.Hat1.addChild(this.Hat2);
        this.Hat1.addChild(this.Hat4);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Hat1.render(f5);
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
