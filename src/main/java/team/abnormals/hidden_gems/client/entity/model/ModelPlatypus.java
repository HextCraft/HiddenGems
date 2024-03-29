package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelPlatypus - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelPlatypus extends EntityModel {
    public Cuboid Head;
    public Cuboid Body;
    public Cuboid RightFrontFoot;
    public Cuboid LeftFrontFoot;
    public Cuboid RightBackLeg;
    public Cuboid LeftBackLeg;
    public Cuboid Hat1;
    public Cuboid Beak;
    public Cuboid Tail;
    public Cuboid RightBackFoot;
    public Cuboid LeftBackFoot;
    public Cuboid Hat2;
    public Cuboid Hat3;
    public Cuboid Hat4;

    public ModelPlatypus() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.RightBackFoot = new Cuboid(this, 12, 26);
        this.RightBackFoot.setRotationPoint(-1.0F, 2.25F, -1.6F);
        this.RightBackFoot.addBox(-2.0F, 0.0F, -3.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(RightBackFoot, -0.4363323129985824F, 0.0F, 0.0F);
        this.Hat2 = new Cuboid(this, 34, 15);
        this.Hat2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat2.addBox(-2.0F, -2.5F, -2.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(Hat2, -0.17453292519943295F, 0.0F, 0.0F);
        this.Tail = new Cuboid(this, 0, 14);
        this.Tail.setRotationPoint(0.0F, -0.75F, 7.0F);
        this.Tail.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 8, 0.0F);
        this.setRotateAngle(Tail, -0.5235987755982988F, 0.0F, 0.0F);
        this.Hat4 = new Cuboid(this, 56, 15);
        this.Hat4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat4.addBox(1.0F, -3.5F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Hat4, -0.17453292519943295F, 0.0F, 0.0F);
        this.Hat3 = new Cuboid(this, 46, 14);
        this.Hat3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat3.addBox(-2.0F, -3.5F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(Hat3, -0.17453292519943295F, 0.0F, 0.0F);
        this.RightFrontFoot = new Cuboid(this, 0, 24);
        this.RightFrontFoot.setRotationPoint(-2.5F, 21.0F, 0.0F);
        this.RightFrontFoot.addBox(-3.0F, 0.0F, -2.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(RightFrontFoot, 0.0F, 0.4363323129985824F, 0.0F);
        this.LeftBackFoot = new Cuboid(this, 12, 26);
        this.LeftBackFoot.mirror = true;
        this.LeftBackFoot.setRotationPoint(1.0F, 2.25F, -1.6F);
        this.LeftBackFoot.addBox(-2.0F, 0.0F, -3.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(LeftBackFoot, -0.4363323129985824F, 0.0F, 0.0F);
        this.Beak = new Cuboid(this, 32, 2);
        this.Beak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beak.addBox(-2.0F, -0.25F, -8.8F, 4, 2, 5, 0.0F);
        this.Hat1 = new Cuboid(this, 16, 15);
        this.Hat1.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.Hat1.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F);
        this.setRotateAngle(Hat1, 0.17453292519943295F, 0.0F, 0.0F);
        this.Body = new Cuboid(this, 12, 1);
        this.Body.setRotationPoint(0.0F, 19.8F, 0.0F);
        this.Body.addBox(-3.0F, -2.0F, 0.0F, 6, 5, 8, 0.0F);
        this.LeftBackLeg = new Cuboid(this, 0, 17);
        this.LeftBackLeg.setRotationPoint(2.75F, 21.0F, 6.0F);
        this.LeftBackLeg.addBox(0.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(LeftBackLeg, 0.4363323129985824F, -0.4363323129985824F, 0.0F);
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Head.addBox(-2.5F, -2.0F, -4.0F, 5, 4, 5, 0.0F);
        this.RightBackLeg = new Cuboid(this, 0, 17);
        this.RightBackLeg.setRotationPoint(-2.75F, 21.0F, 6.0F);
        this.RightBackLeg.addBox(-2.0F, -0.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(RightBackLeg, 0.4363323129985824F, 0.4363323129985824F, 0.0F);
        this.LeftFrontFoot = new Cuboid(this, 0, 24);
        this.LeftFrontFoot.mirror = true;
        this.LeftFrontFoot.setRotationPoint(2.5F, 21.0F, 0.0F);
        this.LeftFrontFoot.addBox(0.0F, 0.0F, -2.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(LeftFrontFoot, 0.0F, -0.4363323129985824F, 0.0F);
        this.RightBackLeg.addChild(this.RightBackFoot);
        this.Hat1.addChild(this.Hat2);
        this.Body.addChild(this.Tail);
        this.Hat1.addChild(this.Hat4);
        this.Hat1.addChild(this.Hat3);
        this.LeftBackLeg.addChild(this.LeftBackFoot);
        this.Head.addChild(this.Beak);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.RightFrontFoot.render(f5);
        this.Hat1.render(f5);
        this.Body.render(f5);
        this.LeftBackLeg.render(f5);
        this.Head.render(f5);
        this.RightBackLeg.render(f5);
        this.LeftFrontFoot.render(f5);
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
