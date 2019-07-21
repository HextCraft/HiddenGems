package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * ModelMahiMahi - Undefined
 * Created using Tabula 7.0.1
 */
public class MahiMahiModel extends EntityModel {
    public Cuboid Head;
    public Cuboid Body1;
    public Cuboid Body2;
    public Cuboid Body3;
    public Cuboid Forehead;
    public Cuboid TopFin1;
    public Cuboid TopFin2;
    public Cuboid RightFin;
    public Cuboid LeftFin;
    public Cuboid TopFin3;
    public Cuboid TopFin4;
    public Cuboid Tail;

    public MahiMahiModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Head = new Cuboid(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.Head.addBox(-3.0F, -5.0F, -8.0F, 6, 10, 8, 0.0F);
        this.LeftFin = new Cuboid(this, 0, 20);
        this.LeftFin.mirror = true;
        this.LeftFin.setRotationPoint(2.9F, 0.0F, 0.0F);
        this.LeftFin.addBox(0.0F, -1.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(LeftFin, 0.4363323129985824F, 0.4363323129985824F, 0.0F);
        this.TopFin3 = new Cuboid(this, 54, 26);
        this.TopFin3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopFin3.addBox(0.0F, -8.5F, 0.0F, 1, 15, 10, 0.0F);
        this.TopFin1 = new Cuboid(this, 0, 30);
        this.TopFin1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopFin1.addBox(0.0F, -9.5F, -10.0F, 1, 5, 10, 0.0F);
        this.Forehead = new Cuboid(this, 24, 0);
        this.Forehead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Forehead.addBox(-3.0F, -5.0F, -10.0F, 6, 5, 2, 0.0F);
        this.TopFin2 = new Cuboid(this, 22, 20);
        this.TopFin2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopFin2.addBox(0.0F, -9.5F, 0.0F, 1, 18, 10, 0.0F);
        this.Tail = new Cuboid(this, 90, 40);
        this.Tail.setRotationPoint(0.0F, 0.0F, 8.5F);
        this.Tail.addBox(0.0F, -6.0F, 0.0F, 1, 12, 12, 0.0F);
        this.Body1 = new Cuboid(this, 0, 46);
        this.Body1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Body1.addBox(-3.0F, -4.0F, 0.0F, 6, 8, 10, 0.0F);
        this.RightFin = new Cuboid(this, 0, 20);
        this.RightFin.setRotationPoint(-2.9F, 0.0F, 0.0F);
        this.RightFin.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(RightFin, 0.4363323129985824F, -0.4363323129985824F, 0.0F);
        this.Body2 = new Cuboid(this, 32, 48);
        this.Body2.setRotationPoint(0.0F, 1.0F, 10.0F);
        this.Body2.addBox(-3.0F, -2.5F, 0.0F, 6, 6, 10, 0.0F);
        this.Body3 = new Cuboid(this, 64, 51);
        this.Body3.setRotationPoint(0.0F, 2.5F, 20.0F);
        this.Body3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 10, 0.0F);
        this.TopFin4 = new Cuboid(this, 78, 27);
        this.TopFin4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TopFin4.addBox(0.0F, -8.0F, 0.0F, 1, 14, 10, 0.0F);
        this.Body1.addChild(this.LeftFin);
        this.Body2.addChild(this.TopFin3);
        this.Head.addChild(this.TopFin1);
        this.Head.addChild(this.Forehead);
        this.Body1.addChild(this.TopFin2);
        this.Body3.addChild(this.Tail);
        this.Body1.addChild(this.RightFin);
        this.Body3.addChild(this.TopFin4);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.render(f5);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.Body3.render(f5);
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
