package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelMermaid - Undefined
 * Created using Tabula 7.0.1
 */
public class MermaidModel extends EntityModel {
    public Cuboid Head;
    public Cuboid HairLayer;
    public Cuboid Body;
    public Cuboid RightArm;
    public Cuboid LeftArm;
    public Cuboid Tail1;
    public Cuboid Hair;
    public Cuboid Tail2;
    public Cuboid Tail3;

    public MermaidModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightArm = new Cuboid(this, 0, 17);
        this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.HairLayer = new Cuboid(this, 32, 0);
        this.HairLayer.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HairLayer.addBox(-4.0F, -8.0F, -4.0F, 8, 12, 8, 0.25F);
        this.Hair = new Cuboid(this, 0, 51);
        this.Hair.setRotationPoint(0.0F, 0.0F, -2.1F);
        this.Hair.addBox(-4.5F, 0.0F, 0.0F, 9, 12, 1, 0.0F);
        this.setRotateAngle(Hair, -0.03490658503988659F, 0.0F, 0.0F);
        this.LeftArm = new Cuboid(this, 0, 17);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.0F);
        this.Tail2 = new Cuboid(this, 23, 31);
        this.Tail2.setRotationPoint(0.0F, 7.0F, -1.0F);
        this.Tail2.addBox(-2.0F, 0.0F, -1.0F, 4, 8, 2, 0.0F);
        this.setRotateAngle(Tail2, 0.3490658503988659F, 0.0F, 0.0F);
        this.Body = new Cuboid(this, 40, 20);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 14, 4, 0.0F);
        this.Tail3 = new Cuboid(this, 20, 51);
        this.Tail3.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Tail3.addBox(-6.0F, 0.0F, -1.0F, 12, 12, 1, 0.0F);
        this.setRotateAngle(Tail3, 0.4363323129985824F, 0.0F, 0.0F);
        this.Tail1 = new Cuboid(this, 20, 20);
        this.Tail1.setRotationPoint(0.0F, 13.0F, 1.0F);
        this.Tail1.addBox(-3.0F, 0.0F, -2.0F, 6, 8, 3, 0.0F);
        this.setRotateAngle(Tail1, 0.3490658503988659F, 0.0F, 0.0F);
        this.Body.addChild(this.Hair);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.Tail3);
        this.Body.addChild(this.Tail1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.RightArm.render(f5);
        this.Head.render(f5);
        this.HairLayer.render(f5);
        this.LeftArm.render(f5);
        this.Body.render(f5);
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
