//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package team.abnormals.hidden_gems.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.Container;
import net.minecraft.container.LecternContainer;
import net.minecraft.container.NameableContainerProvider;
import net.minecraft.container.PropertyDelegate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import team.abnormals.hidden_gems.block.BaseLecternBlock;
import team.abnormals.hidden_gems.init.HGBlockEntities;
import team.abnormals.hidden_gems.utils.enums.WoodType;

import javax.annotation.Nullable;
import java.util.Objects;

public class LecternBlockEntity extends BlockEntity implements Clearable, NameableContainerProvider {
    private ItemStack book;
    private int currentPage;
    private int pageCount;
    private final Inventory inventory = new Inventory() {
        public int getInvSize() {
            return 1;
        }

        public boolean isInvEmpty() {
            return LecternBlockEntity.this.book.isEmpty();
        }

        public ItemStack getInvStack(int int_1) {
            return int_1 == 0 ? LecternBlockEntity.this.book : ItemStack.EMPTY;
        }

        public ItemStack takeInvStack(int int_1, int int_2) {
            if (int_1 == 0) {
                ItemStack itemStack_1 = LecternBlockEntity.this.book.split(int_2);
                if (LecternBlockEntity.this.book.isEmpty()) {
                    LecternBlockEntity.this.onBookRemoved();
                }

                return itemStack_1;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public ItemStack removeInvStack(int int_1) {
            if (int_1 == 0) {
                ItemStack itemStack_1 = LecternBlockEntity.this.book;
                LecternBlockEntity.this.book = ItemStack.EMPTY;
                LecternBlockEntity.this.onBookRemoved();
                return itemStack_1;
            } else {
                return ItemStack.EMPTY;
            }
        }

        public void setInvStack(int int_1, ItemStack itemStack_1) {
        }

        public int getInvMaxStackAmount() {
            return 1;
        }

        public void markDirty() {
            LecternBlockEntity.this.markDirty();
        }

        public boolean canPlayerUseInv(PlayerEntity playerEntity_1) {
            if (LecternBlockEntity.this.world.getBlockEntity(LecternBlockEntity.this.pos) != LecternBlockEntity.this) {
                return false;
            } else {
                return !(playerEntity_1.squaredDistanceTo((double) LecternBlockEntity.this.pos.getX() + 0.5D, (double) LecternBlockEntity.this.pos.getY() + 0.5D, (double) LecternBlockEntity.this.pos.getZ() + 0.5D) > 64.0D) && LecternBlockEntity.this.hasBook();
            }
        }

        public boolean isValidInvStack(int int_1, ItemStack itemStack_1) {
            return false;
        }

        public void clear() {
        }
    };
    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        public int get(int int_1) {
            return int_1 == 0 ? LecternBlockEntity.this.currentPage : 0;
        }

        public void set(int int_1, int int_2) {
            if (int_1 == 0) {
                LecternBlockEntity.this.setCurrentPage(int_2);
            }

        }

        public int size() {
            return 1;
        }
    };

    public LecternBlockEntity(WoodType woodType) {
        super(HGBlockEntities.LECTERNS[woodType.getIndex()]);
        this.book = ItemStack.EMPTY;
    }

    public ItemStack getBook() {
        return this.book;
    }

    public void setBook(ItemStack itemStack_1) {
        this.setBook(itemStack_1, null);
    }

    public boolean hasBook() {
        Item item_1 = this.book.getItem();
        return item_1 == Items.WRITABLE_BOOK || item_1 == Items.WRITTEN_BOOK;
    }

    private void onBookRemoved() {
        this.currentPage = 0;
        this.pageCount = 0;
        BaseLecternBlock.setHasBook(Objects.requireNonNull(this.getWorld()), this.getPos(), this.getCachedState(), false);
    }

    public void setBook(ItemStack itemStack_1, @Nullable PlayerEntity playerEntity_1) {
        this.book = this.resolveBook(itemStack_1, playerEntity_1);
        this.currentPage = 0;
        this.pageCount = WrittenBookItem.getPageCount(this.book);
        this.markDirty();
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    private void setCurrentPage(int int_1) {
        int int_2 = MathHelper.clamp(int_1, 0, this.pageCount - 1);
        if (int_2 != this.currentPage) {
            this.currentPage = int_2;
            this.markDirty();
            BaseLecternBlock.setPowered(this.getWorld(), this.getPos(), this.getCachedState());
        }

    }

    public int getComparatorOutput() {
        float float_1 = this.pageCount > 1 ? (float) this.getCurrentPage() / ((float) this.pageCount - 1.0F) : 1.0F;
        return MathHelper.floor(float_1 * 14.0F) + (this.hasBook() ? 1 : 0);
    }

    private ItemStack resolveBook(ItemStack itemStack_1, @Nullable PlayerEntity playerEntity_1) {
        if (this.world instanceof ServerWorld && itemStack_1.getItem() == Items.WRITTEN_BOOK) {
            WrittenBookItem.resolve(itemStack_1, this.getCommandSource(playerEntity_1), playerEntity_1);
        }

        return itemStack_1;
    }

    private ServerCommandSource getCommandSource(@Nullable PlayerEntity playerEntity_1) {
        String string_2;
        Object text_2;
        if (playerEntity_1 == null) {
            string_2 = "Lectern";
            text_2 = new LiteralText("Lectern");
        } else {
            string_2 = playerEntity_1.getName().getString();
            text_2 = playerEntity_1.getDisplayName();
        }

        Vec3d vec3d_1 = new Vec3d((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D);
        return new ServerCommandSource(CommandOutput.DUMMY, vec3d_1, Vec2f.ZERO, (ServerWorld) this.world, 2, string_2, (Text) text_2, this.world.getServer(), playerEntity_1);
    }

    public boolean shouldNotCopyTagFromItem() {
        return true;
    }

    public void fromTag(CompoundTag compoundTag_1) {
        super.fromTag(compoundTag_1);
        if (compoundTag_1.containsKey("Book", 10)) {
            this.book = this.resolveBook(ItemStack.fromTag(compoundTag_1.getCompound("Book")), null);
        } else {
            this.book = ItemStack.EMPTY;
        }

        this.pageCount = WrittenBookItem.getPageCount(this.book);
        this.currentPage = MathHelper.clamp(compoundTag_1.getInt("Page"), 0, this.pageCount - 1);
    }

    public CompoundTag toTag(CompoundTag compoundTag_1) {
        super.toTag(compoundTag_1);
        if (!this.getBook().isEmpty()) {
            compoundTag_1.put("Book", this.getBook().toTag(new CompoundTag()));
            compoundTag_1.putInt("Page", this.currentPage);
        }

        return compoundTag_1;
    }

    public void clear() {
        this.setBook(ItemStack.EMPTY);
    }

    public Container createMenu(int int_1, PlayerInventory playerInventory_1, PlayerEntity playerEntity_1) {
        return new LecternContainer(int_1, this.inventory, this.propertyDelegate);
    }

    public Text getDisplayName() {
        return new TranslatableText("container.lectern");
    }
}
