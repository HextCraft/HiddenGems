package team.abnormals.hidden_gems.mixin.blocks;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.StructureBlockBlockEntity;
import net.minecraft.block.enums.StructureBlockMode;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;

@Mixin(StructureBlockBlockEntity.class)
public abstract class StructureBlockBlockEntityMixin extends BlockEntity {

    @Shadow
    private String author;
    @Shadow
    private String metadata;
    @Shadow
    private BlockPos offset;
    @Shadow
    private BlockPos size;
    @Shadow
    private BlockRotation rotation;
    @Shadow
    private BlockMirror mirror;
    @Shadow
    private StructureBlockMode mode;
    @Shadow
    private boolean ignoreEntities;
    @Shadow
    private boolean powered;
    @Shadow
    private boolean showAir;
    @Shadow
    private boolean showBoundingBox;
    @Shadow
    private float integrity;
    @Shadow
    private long seed;
    public StructureBlockBlockEntityMixin(BlockEntityType<?> blockEntityType_1) {
        super(blockEntityType_1);
    }

    @Shadow
    public abstract void setStructureName(@Nullable String string_1);

    @Shadow
    protected abstract void updateBlockMode();

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        this.setStructureName(tag.getString("name"));
        this.author = tag.getString("author");
        this.metadata = tag.getString("metadata");
        int posX = MathHelper.clamp(tag.getInt("posX"), -256, 256);
        int posY = MathHelper.clamp(tag.getInt("posY"), -256, 256);
        int posZ = MathHelper.clamp(tag.getInt("posZ"), -256, 256);
        this.offset = new BlockPos(posX, posY, posZ);
        int sizeX = MathHelper.clamp(tag.getInt("sizeX"), 0, 256);
        int sizeY = MathHelper.clamp(tag.getInt("sizeY"), 0, 256);
        int sizeZ = MathHelper.clamp(tag.getInt("sizeZ"), 0, 256);
        this.size = new BlockPos(sizeX, sizeY, sizeZ);

        try {
            this.rotation = BlockRotation.valueOf(tag.getString("rotation"));
        } catch (IllegalArgumentException var11) {
            this.rotation = BlockRotation.NONE;
        }

        try {
            this.mirror = BlockMirror.valueOf(tag.getString("mirror"));
        } catch (IllegalArgumentException var10) {
            this.mirror = BlockMirror.NONE;
        }

        try {
            this.mode = StructureBlockMode.valueOf(tag.getString("mode"));
        } catch (IllegalArgumentException var9) {
            this.mode = StructureBlockMode.DATA;
        }

        this.ignoreEntities = tag.getBoolean("ignoreEntities");
        this.powered = tag.getBoolean("powered");
        this.showAir = tag.getBoolean("showair");
        this.showBoundingBox = tag.getBoolean("showboundingbox");
        if (tag.containsKey("integrity")) {
            this.integrity = tag.getFloat("integrity");
        } else {
            this.integrity = 1.0F;
        }

        this.seed = tag.getLong("seed");
        this.updateBlockMode();
    }
}
