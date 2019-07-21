package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelTheWellWisher - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelTheWellWisher extends EntityModel {
    public Cuboid Head;
    public Cuboid Hat;
    public Cuboid Hat4;
    public Cuboid Hat6;
    public Cuboid Hat7;
    public Cuboid Body;
    public Cuboid RightArm;
    public Cuboid LeftArm;
    public Cuboid Hair;
    public Cuboid Hat5;
    public Cuboid RightLeg;
    public Cuboid RightLegLayer;
    public Cuboid LeftLeg;
    public Cuboid LeftLegLayer;
    public Cuboid Hat2;
    public Cuboid Hat3;

    public ModelTheWellWisher() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Hat7 = new Cuboid(this, 46, 39);
        this.Hat7.setRotationPoint(0.0F, -5.0F, 4.0F);
        this.Hat7.addBox(-4.0F, 0.0F, 0.0F, 8, 4, 1, 0.0F);
        this.Hat2 = new Cuboid(this, 24, 0);
        this.Hat2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat2.addBox(-2.0F, -11.0F, -2.0F, 4, 2, 4, 0.0F);
        this.LeftLegLayer = new Cuboid(this, 0, 32);
        this.LeftLegLayer.mirror = true;
        this.LeftLegLayer.setRotationPoint(2.0F, 13.0F, 0.0F);
        this.LeftLegLayer.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.25F);
        this.setRotateAngle(LeftLegLayer, 0.2617993877991494F, 0.08726646259971647F, 0.0F);
        this.RightArm = new Cuboid(this, 40, 17);
        this.RightArm.setRotationPoint(-5.0F, 4.0F, 0.0F);
        this.RightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 11, 4, 0.0F);
        this.setRotateAngle(RightArm, -1.2217304763960306F, -0.17453292519943295F, 0.0F);
        this.Body = new Cuboid(this, 16, 17);
        this.Body.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4, 0.0F);
        this.Hat6 = new Cuboid(this, 7, 47);
        this.Hat6.setRotationPoint(3.5F, -6.0F, -3.75F);
        this.Hat6.addBox(-0.5F, 0.0F, -1.0F, 1, 7, 1, 0.0F);
        this.RightLeg = new Cuboid(this, 0, 17);
        this.RightLeg.setRotationPoint(-2.0F, 13.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);
        this.setRotateAngle(RightLeg, 0.2617993877991494F, -0.08726646259971647F, 0.0F);
        this.LeftLeg = new Cuboid(this, 0, 17);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(2.0F, 13.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);
        this.setRotateAngle(LeftLeg, 0.2617993877991494F, 0.08726646259971647F, 0.0F);
        this.Hat = new Cuboid(this, 32, 0);
        this.Hat.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Hat.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.Hair = new Cuboid(this, 16, 33);
        this.Hair.setRotationPoint(0.0F, 2.0F, 2.0F);
        this.Hair.addBox(-4.0F, 0.0F, 0.0F, 8, 16, 1, 0.0F);
        this.setRotateAngle(Hair, 0.08726646259971647F, 0.0F, 0.0F);
        this.RightLegLayer = new Cuboid(this, 0, 32);
        this.RightLegLayer.setRotationPoint(-2.0F, 13.0F, 0.0F);
        this.RightLegLayer.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.25F);
        this.setRotateAngle(RightLegLayer, 0.2617993877991494F, -0.08726646259971647F, 0.0F);
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Head.addBox(-4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F);
        this.LeftArm = new Cuboid(this, 40, 17);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(5.0F, 4.0F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 11, 4, 0.0F);
        this.setRotateAngle(LeftArm, -1.2217304763960306F, 0.17453292519943295F, 0.0F);
        this.Hat5 = new Cuboid(this, 1, 47);
        this.Hat5.setRotationPoint(4.25F, -3.0F, -3.0F);
        this.Hat5.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.Hat4 = new Cuboid(this, 1, 47);
        this.Hat4.setRotationPoint(-4.0F, -6.0F, -1.0F);
        this.Hat4.addBox(-1.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.Hat3 = new Cuboid(this, 40, 32);
        this.Hat3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat3.addBox(-3.0F, -12.0F, -3.0F, 6, 1, 6, 0.0F);
        this.Head.addChild(this.Hat2);
        this.Head.addChild(this.Hat3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Hat7.render(f5);
        this.LeftLegLayer.render(f5);
        this.RightArm.render(f5);
        this.Body.render(f5);
        this.Hat6.render(f5);
        this.RightLeg.render(f5);
        this.LeftLeg.render(f5);
        this.Hat.render(f5);
        this.Hair.render(f5);
        this.RightLegLayer.render(f5);
        this.Head.render(f5);
        this.LeftArm.render(f5);
        this.Hat5.render(f5);
        this.Hat4.render(f5);
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
