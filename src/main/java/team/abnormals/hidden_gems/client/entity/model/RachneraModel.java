package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelRachnera - Undefined
 * Created using Tabula 7.0.1
 */
public class RachneraModel extends EntityModel {
    public Cuboid Head;
    public Cuboid Body;
    public Cuboid RightArm;
    public Cuboid LeftArm;
    public Cuboid SpiderBody;
    public Cuboid Hair;
    public Cuboid Bobs;
    public Cuboid Cloth;
    public Cuboid RightLeg1;
    public Cuboid RightLeg2;
    public Cuboid RightLeg3;
    public Cuboid RightLeg4;
    public Cuboid LegLeg1;
    public Cuboid LeftLeg2;
    public Cuboid LeftLeg3;
    public Cuboid LeftLeg4;

    public RachneraModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -11.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.RightLeg2 = new Cuboid(this, 0, 27);
        this.RightLeg2.setRotationPoint(-6.0F, -6.0F, 8.0F);
        this.RightLeg2.addBox(-20.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(RightLeg2, 0.0F, 0.03490658503988659F, 0.0F);
        this.RightLeg3 = new Cuboid(this, 0, 27);
        this.RightLeg3.setRotationPoint(-6.0F, -6.0F, 5.0F);
        this.RightLeg3.addBox(-20.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(RightLeg3, 0.0F, -0.2617993877991494F, 0.0F);
        this.RightLeg4 = new Cuboid(this, 0, 27);
        this.RightLeg4.setRotationPoint(-6.0F, -6.0F, 3.0F);
        this.RightLeg4.addBox(-20.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(RightLeg4, 0.0F, -0.5235987755982988F, 0.0F);
        this.LeftLeg4 = new Cuboid(this, 0, 27);
        this.LeftLeg4.mirror = true;
        this.LeftLeg4.setRotationPoint(6.0F, -6.0F, 3.0F);
        this.LeftLeg4.addBox(0.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(LeftLeg4, 0.0F, 0.5235987755982988F, 0.0F);
        this.LeftArm = new Cuboid(this, 46, 12);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(5.0F, -8.5F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(LeftArm, 0.0F, 0.0F, -0.08726646259971647F);
        this.RightLeg1 = new Cuboid(this, 0, 27);
        this.RightLeg1.setRotationPoint(-6.0F, -6.0F, 10.0F);
        this.RightLeg1.addBox(-20.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(RightLeg1, 0.0F, 0.5235987755982988F, 0.0F);
        this.LeftLeg3 = new Cuboid(this, 0, 27);
        this.LeftLeg3.mirror = true;
        this.LeftLeg3.setRotationPoint(6.0F, -6.0F, 5.0F);
        this.LeftLeg3.addBox(0.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(LeftLeg3, 0.0F, 0.2617993877991494F, 0.0F);
        this.Hair = new Cuboid(this, 32, 0);
        this.Hair.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hair.addBox(-4.0F, 0.0F, -4.0F, 8, 4, 8, 0.0F);
        this.SpiderBody = new Cuboid(this, 42, 32);
        this.SpiderBody.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.SpiderBody.addBox(-8.0F, -6.0F, 0.0F, 16, 12, 20, 0.0F);
        this.Bobs = new Cuboid(this, 64, 0);
        this.Bobs.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Bobs.addBox(-4.0F, 2.0F, -5.0F, 8, 6, 3, 0.0F);
        this.Body = new Cuboid(this, 60, 9);
        this.Body.setRotationPoint(0.0F, -11.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 14, 4, 0.0F);
        this.LegLeg1 = new Cuboid(this, 0, 27);
        this.LegLeg1.setRotationPoint(6.0F, -6.0F, 10.0F);
        this.LegLeg1.addBox(0.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(LegLeg1, 0.0F, -0.5235987755982988F, 0.0F);
        this.RightArm = new Cuboid(this, 46, 12);
        this.RightArm.setRotationPoint(-5.0F, -8.5F, 0.0F);
        this.RightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.setRotateAngle(RightArm, 0.0F, 0.0F, 0.08726646259971647F);
        this.Cloth = new Cuboid(this, 86, 0);
        this.Cloth.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.Cloth.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.LeftLeg2 = new Cuboid(this, 0, 27);
        this.LeftLeg2.mirror = true;
        this.LeftLeg2.setRotationPoint(6.0F, -6.0F, 8.0F);
        this.LeftLeg2.addBox(0.0F, -12.0F, 0.0F, 20, 36, 1, 0.0F);
        this.setRotateAngle(LeftLeg2, 0.0F, -0.03490658503988659F, 0.0F);
        this.SpiderBody.addChild(this.RightLeg2);
        this.SpiderBody.addChild(this.RightLeg3);
        this.SpiderBody.addChild(this.RightLeg4);
        this.SpiderBody.addChild(this.LeftLeg4);
        this.SpiderBody.addChild(this.RightLeg1);
        this.SpiderBody.addChild(this.LeftLeg3);
        this.Head.addChild(this.Hair);
        this.Body.addChild(this.Bobs);
        this.SpiderBody.addChild(this.LegLeg1);
        this.Body.addChild(this.Cloth);
        this.SpiderBody.addChild(this.LeftLeg2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.render(f5);
        this.LeftArm.render(f5);
        this.SpiderBody.render(f5);
        this.Body.render(f5);
        this.RightArm.render(f5);
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
