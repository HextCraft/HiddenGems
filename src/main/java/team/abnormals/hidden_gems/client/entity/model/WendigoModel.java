package team.abnormals.hidden_gems.client.entity.model;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * Wendigo - me
 * Created using Tabula 7.0.1
 */
public class WendigoModel extends EntityModel {
    public Cuboid TopTorso;
    public Cuboid HeadLayer;
    public Cuboid BottomTorso;
    public Cuboid Head;
    public Cuboid RightArm1;
    public Cuboid LeftArm1;
    public Cuboid RightLeg1;
    public Cuboid LeftLeg1;
    public Cuboid RightLeg2;
    public Cuboid LeftLeg2;
    public Cuboid LeftAntler;
    public Cuboid RightAntler;
    public Cuboid RightArm2;
    public Cuboid LeftArm2;

    public WendigoModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftArm1 = new Cuboid(this, 20, 50);
        this.LeftArm1.mirror = true;
        this.LeftArm1.setRotationPoint(3.0F, -8.0F, 1.0F);
        this.LeftArm1.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(LeftArm1, 0.3490658503988659F, 0.2617993877991494F, -0.5235987755982988F);
        this.LeftArm2 = new Cuboid(this, 28, 46);
        this.LeftArm2.setRotationPoint(-0.01F, 11.0F, 0.0F);
        this.LeftArm2.addBox(-1.0F, 0.5F, -1.0F, 2, 16, 2, 0.0F);
        this.setRotateAngle(LeftArm2, -0.8726646259971648F, 0.0F, 0.0F);
        this.LeftLeg1 = new Cuboid(this, 0, 48);
        this.LeftLeg1.mirror = true;
        this.LeftLeg1.setRotationPoint(1.9F, 7.0F, 0.0F);
        this.LeftLeg1.addBox(-1.5F, 0.0F, -1.0F, 3, 13, 3, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.17453292519943295F, 0.0F, 0.0F);
        this.RightArm2 = new Cuboid(this, 28, 46);
        this.RightArm2.setRotationPoint(0.01F, 11.0F, 0.0F);
        this.RightArm2.addBox(-1.0F, 0.5F, -1.0F, 2, 16, 2, 0.0F);
        this.setRotateAngle(RightArm2, -0.8726646259971648F, 0.0F, 0.0F);
        this.RightAntler = new Cuboid(this, 50, 0);
        this.RightAntler.setRotationPoint(-1.0F, -5.5F, 0.0F);
        this.RightAntler.addBox(-1.0F, -10.0F, -3.0F, 1, 10, 6, 0.0F);
        this.setRotateAngle(RightAntler, -0.17453292519943295F, 0.4363323129985824F, -0.3490658503988659F);
        this.LeftAntler = new Cuboid(this, 50, 0);
        this.LeftAntler.mirror = true;
        this.LeftAntler.setRotationPoint(1.0F, -5.5F, 0.0F);
        this.LeftAntler.addBox(0.0F, -10.0F, -3.0F, 1, 10, 6, 0.0F);
        this.setRotateAngle(LeftAntler, -0.17453292519943295F, -0.4363323129985824F, 0.3490658503988659F);
        this.TopTorso = new Cuboid(this, 0, 0);
        this.TopTorso.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.TopTorso.addBox(-4.0F, -9.0F, -2.0F, 8, 9, 5, 0.0F);
        this.setRotateAngle(TopTorso, 0.17453292519943295F, 0.0F, 0.0F);
        this.Head = new Cuboid(this, 0, 14);
        this.Head.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.Head.addBox(-2.5F, -6.0F, -7.0F, 5, 6, 9, 0.0F);
        this.setRotateAngle(Head, -0.03490658503988659F, 0.0F, 0.0F);
        this.RightLeg2 = new Cuboid(this, 12, 52);
        this.RightLeg2.setRotationPoint(0.0F, 13.0F, -1.0F);
        this.RightLeg2.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(RightLeg2, 0.3490658503988659F, 0.0F, 0.0F);
        this.RightArm1 = new Cuboid(this, 20, 50);
        this.RightArm1.setRotationPoint(-3.0F, -8.0F, 1.0F);
        this.RightArm1.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(RightArm1, 0.3490658503988659F, -0.2617993877991494F, 0.5235987755982988F);
        this.LeftLeg2 = new Cuboid(this, 12, 52);
        this.LeftLeg2.mirror = true;
        this.LeftLeg2.setRotationPoint(0.0F, 13.0F, -1.0F);
        this.LeftLeg2.addBox(-1.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.setRotateAngle(LeftLeg2, 0.3490658503988659F, 0.0F, 0.0F);
        this.RightLeg1 = new Cuboid(this, 0, 48);
        this.RightLeg1.setRotationPoint(-1.9F, 7.0F, 0.0F);
        this.RightLeg1.addBox(-1.5F, 0.0F, -1.0F, 3, 13, 3, 0.0F);
        this.setRotateAngle(RightLeg1, -0.17453292519943295F, 0.0F, 0.0F);
        this.HeadLayer = new Cuboid(this, 36, 49);
        this.HeadLayer.setRotationPoint(0.0F, -13.0F, -1.4F);
        this.HeadLayer.addBox(-2.5F, -6.0F, -7.5F, 5, 6, 9, 0.25F);
        this.setRotateAngle(HeadLayer, 0.13962634015954636F, 0.0F, 0.0F);
        this.BottomTorso = new Cuboid(this, 26, 0);
        this.BottomTorso.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.BottomTorso.addBox(-3.0F, 0.0F, -2.0F, 6, 8, 4, 0.0F);
        this.setRotateAngle(BottomTorso, -0.17453292519943295F, 0.0F, 0.0F);
        this.TopTorso.addChild(this.LeftArm1);
        this.LeftArm1.addChild(this.LeftArm2);
        this.BottomTorso.addChild(this.LeftLeg1);
        this.RightArm1.addChild(this.RightArm2);
        this.Head.addChild(this.RightAntler);
        this.Head.addChild(this.LeftAntler);
        this.TopTorso.addChild(this.Head);
        this.RightLeg1.addChild(this.RightLeg2);
        this.TopTorso.addChild(this.RightArm1);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.BottomTorso.addChild(this.RightLeg1);
        this.TopTorso.addChild(this.BottomTorso);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.TopTorso.render(f5);
        this.HeadLayer.render(f5);
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
