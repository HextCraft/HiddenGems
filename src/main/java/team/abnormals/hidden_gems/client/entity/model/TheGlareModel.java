package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * The Glare - Undefined
 * Created using Tabula 7.0.1
 */
public class TheGlareModel extends EntityModel {
    public Cuboid Fire;
    public Cuboid MiddleBody;
    public Cuboid TopBody;
    public Cuboid BottomBody;
    public Cuboid Limb1;
    public Cuboid Limb2;
    public Cuboid Limb3;
    public Cuboid Limb4;
    public Cuboid Fin1;
    public Cuboid Fin2;
    public Cuboid Fin3;
    public Cuboid Fin4;

    public TheGlareModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Fin4 = new Cuboid(this, 96, 2);
        this.Fin4.setRotationPoint(0.0F, 1.0F, 6.0F);
        this.Fin4.addBox(0.0F, 0.0F, -6.0F, 0, 4, 12, 0.0F);
        this.Fin1 = new Cuboid(this, 80, 8);
        this.Fin1.setRotationPoint(0.0F, 1.0F, -6.0F);
        this.Fin1.addBox(0.0F, 0.0F, -6.0F, 0, 4, 12, 0.0F);
        this.MiddleBody = new Cuboid(this, 0, 0);
        this.MiddleBody.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.MiddleBody.addBox(-10.0F, -6.0F, -10.0F, 20, 12, 20, 0.0F);
        this.Limb2 = new Cuboid(this, 80, 6);
        this.Limb2.mirror = true;
        this.Limb2.setRotationPoint(0.0F, -1.5F, 7.0F);
        this.Limb2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 12, 0.0F);
        this.Limb1 = new Cuboid(this, 80, 6);
        this.Limb1.setRotationPoint(0.0F, -1.5F, -7.0F);
        this.Limb1.addBox(-1.0F, -1.0F, -12.0F, 2, 2, 12, 0.0F);
        this.Limb3 = new Cuboid(this, 80, 6);
        this.Limb3.setRotationPoint(-7.0F, -1.5F, 0.0F);
        this.Limb3.addBox(-1.0F, -1.0F, -12.0F, 2, 2, 12, 0.0F);
        this.setRotateAngle(Limb3, 0.0F, 1.5707963267948966F, 0.0F);
        this.Fin3 = new Cuboid(this, 80, 8);
        this.Fin3.setRotationPoint(0.0F, 1.0F, -6.0F);
        this.Fin3.addBox(0.0F, 0.0F, -6.0F, 0, 4, 12, 0.0F);
        this.Fire = new Cuboid(this, 0, 36);
        this.Fire.setRotationPoint(0.0F, 13.5F, 0.0F);
        this.Fire.addBox(-8.0F, -2.0F, -8.0F, 16, 12, 16, -2.5F);
        this.Fin2 = new Cuboid(this, 96, 2);
        this.Fin2.setRotationPoint(0.0F, 1.0F, 6.0F);
        this.Fin2.addBox(0.0F, 0.0F, -6.0F, 0, 4, 12, 0.0F);
        this.BottomBody = new Cuboid(this, 64, 44);
        this.BottomBody.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.BottomBody.addBox(-8.0F, -2.0F, -8.0F, 16, 4, 16, 0.0F);
        this.Limb4 = new Cuboid(this, 60, 0);
        this.Limb4.mirror = true;
        this.Limb4.setRotationPoint(7.0F, -1.5F, 0.0F);
        this.Limb4.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 12, 0.0F);
        this.setRotateAngle(Limb4, 0.0F, 1.5707963267948966F, 0.0F);
        this.TopBody = new Cuboid(this, 64, 24);
        this.TopBody.setRotationPoint(0.0F, -7.5F, 0.0F);
        this.TopBody.addBox(-8.0F, -2.0F, -8.0F, 16, 4, 16, 0.0F);
        this.Limb4.addChild(this.Fin4);
        this.Limb1.addChild(this.Fin1);
        this.BottomBody.addChild(this.Limb2);
        this.BottomBody.addChild(this.Limb1);
        this.BottomBody.addChild(this.Limb3);
        this.Limb3.addChild(this.Fin3);
        this.Limb2.addChild(this.Fin2);
        this.MiddleBody.addChild(this.BottomBody);
        this.BottomBody.addChild(this.Limb4);
        this.MiddleBody.addChild(this.TopBody);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.MiddleBody.render(f5);
        this.Fire.render(f5);
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
