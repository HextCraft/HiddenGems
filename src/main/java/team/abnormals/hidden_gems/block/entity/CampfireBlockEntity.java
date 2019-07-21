//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package team.abnormals.hidden_gems.block.entity;

import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.network.packet.BlockEntityUpdateS2CPacket;
import net.minecraft.inventory.BasicInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Clearable;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import team.abnormals.hidden_gems.init.HGBlockEntities;
import team.abnormals.hidden_gems.utils.enums.WoodType;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class CampfireBlockEntity extends BlockEntity implements Clearable, Tickable {
    private final DefaultedList<ItemStack> itemsBeingCooked;
    private final int[] cookingTimes;
    private final int[] cookingTotalTimes;

    public CampfireBlockEntity(WoodType woodType) {
        super(HGBlockEntities.CAMPFIRES[woodType.getIndex()]);
        this.itemsBeingCooked = DefaultedList.ofSize(4, ItemStack.EMPTY);
        this.cookingTimes = new int[4];
        this.cookingTotalTimes = new int[4];
    }

    public CampfireBlockEntity(BlockEntityType type) {
        super(type);
        this.itemsBeingCooked = DefaultedList.ofSize(4, ItemStack.EMPTY);
        this.cookingTimes = new int[4];
        this.cookingTotalTimes = new int[4];
    }

    public void tick() {
        boolean boolean_1 = this.getCachedState().get(CampfireBlock.LIT);
        boolean boolean_2 = Objects.requireNonNull(this.world).isClient;
        if (boolean_2) {
            if (boolean_1) {
                this.spawnSmokeParticles();
            }

        } else {
            if (boolean_1) {
                this.updateItemsBeingCooked();
            } else {
                for (int int_1 = 0; int_1 < this.itemsBeingCooked.size(); ++int_1) {
                    if (this.cookingTimes[int_1] > 0) {
                        this.cookingTimes[int_1] = MathHelper.clamp(this.cookingTimes[int_1] - 2, 0, this.cookingTotalTimes[int_1]);
                    }
                }
            }

        }
    }

    private void updateItemsBeingCooked() {
        for (int int_1 = 0; int_1 < this.itemsBeingCooked.size(); ++int_1) {
            ItemStack itemStack_1 = this.itemsBeingCooked.get(int_1);
            if (!itemStack_1.isEmpty()) {
                if (this.cookingTimes[int_1] >= this.cookingTotalTimes[int_1]) {
                    Inventory inventory_1 = new BasicInventory(itemStack_1);
                    ItemStack itemStack_2 = Objects.requireNonNull(this.world).getRecipeManager().getFirstMatch(RecipeType.CAMPFIRE_COOKING, inventory_1, this.world)
                            .map((campfireCookingRecipe_1) -> campfireCookingRecipe_1.craft(inventory_1)).orElse(itemStack_1);
                    BlockPos blockPos_1 = this.getPos();
                    ItemScatterer.spawn(this.world, blockPos_1.getX(), blockPos_1.getY(), blockPos_1.getZ(), itemStack_2);
                    this.itemsBeingCooked.set(int_1, ItemStack.EMPTY);
                    this.updateListeners();
                }
            }
        }

    }

    private void spawnSmokeParticles() {
        World world_1 = this.getWorld();
        if (world_1 != null) {
            BlockPos blockPos_1 = this.getPos();
            Random random_1 = world_1.random;
            int int_2;
            if (random_1.nextFloat() < 0.11F) {
                for (int_2 = 0; int_2 < random_1.nextInt(2) + 2; ++int_2) {
                    CampfireBlock.spawnSmokeParticle(world_1, blockPos_1, this.getCachedState().get(CampfireBlock.SIGNAL_FIRE), false);
                }
            }

            int_2 = this.getCachedState().get(CampfireBlock.FACING).getHorizontal();

            for (int int_3 = 0; int_3 < this.itemsBeingCooked.size(); ++int_3) {
                if (!this.itemsBeingCooked.get(int_3).isEmpty() && random_1.nextFloat() < 0.2F) {
                    Direction direction_1 = Direction.fromHorizontal(Math.floorMod(int_3 + int_2, 4));
                    float float_1 = 0.3125F;
                    double double_1 = (double) blockPos_1.getX() + 0.5D - (double) ((float) direction_1.getOffsetX() * 0.3125F) + (double) ((float) direction_1.rotateYClockwise().getOffsetX() * 0.3125F);
                    double double_2 = (double) blockPos_1.getY() + 0.5D;
                    double double_3 = (double) blockPos_1.getZ() + 0.5D - (double) ((float) direction_1.getOffsetZ() * 0.3125F) + (double) ((float) direction_1.rotateYClockwise().getOffsetZ() * 0.3125F);

                    for (int int_4 = 0; int_4 < 4; ++int_4) {
                        world_1.addParticle(ParticleTypes.SMOKE, double_1, double_2, double_3, 0.0D, 5.0E-4D, 0.0D);
                    }
                }
            }

        }
    }

    public DefaultedList<ItemStack> getItemsBeingCooked() {
        return this.itemsBeingCooked;
    }

    public void fromTag(CompoundTag compoundTag_1) {
        super.fromTag(compoundTag_1);
        this.itemsBeingCooked.clear();
        Inventories.fromTag(compoundTag_1, this.itemsBeingCooked);
        int[] ints_2;
        if (compoundTag_1.containsKey("CookingTimes", 11)) {
            ints_2 = compoundTag_1.getIntArray("CookingTimes");
            System.arraycopy(ints_2, 0, this.cookingTimes, 0, Math.min(this.cookingTotalTimes.length, ints_2.length));
        }

        if (compoundTag_1.containsKey("CookingTotalTimes", 11)) {
            ints_2 = compoundTag_1.getIntArray("CookingTotalTimes");
            System.arraycopy(ints_2, 0, this.cookingTotalTimes, 0, Math.min(this.cookingTotalTimes.length, ints_2.length));
        }

    }

    public CompoundTag toTag(CompoundTag compoundTag_1) {
        this.saveInitialChunkData(compoundTag_1);
        compoundTag_1.putIntArray("CookingTimes", this.cookingTimes);
        compoundTag_1.putIntArray("CookingTotalTimes", this.cookingTotalTimes);
        return compoundTag_1;
    }

    private CompoundTag saveInitialChunkData(CompoundTag compoundTag_1) {
        super.toTag(compoundTag_1);
        Inventories.toTag(compoundTag_1, this.itemsBeingCooked, true);
        return compoundTag_1;
    }

    @Nullable
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return new BlockEntityUpdateS2CPacket(this.pos, 13, this.toInitialChunkDataTag());
    }

    public CompoundTag toInitialChunkDataTag() {
        return this.saveInitialChunkData(new CompoundTag());
    }

    public Optional<CampfireCookingRecipe> getRecipeFor(ItemStack itemStack_1) {
        return this.itemsBeingCooked.stream().noneMatch(ItemStack::isEmpty) ? Optional.empty() : this.world.getRecipeManager().getFirstMatch(RecipeType.CAMPFIRE_COOKING, new BasicInventory(itemStack_1), this.world);
    }

    public boolean addItem(ItemStack itemStack_1, int int_1) {
        for (int int_2 = 0; int_2 < this.itemsBeingCooked.size(); ++int_2) {
            ItemStack itemStack_2 = this.itemsBeingCooked.get(int_2);
            if (itemStack_2.isEmpty()) {
                this.cookingTotalTimes[int_2] = int_1;
                this.cookingTimes[int_2] = 0;
                this.itemsBeingCooked.set(int_2, itemStack_1.split(1));
                this.updateListeners();
                return true;
            }
        }

        return false;
    }

    private void updateListeners() {
        this.markDirty();
        this.getWorld().updateListeners(this.getPos(), this.getCachedState(), this.getCachedState(), 3);
    }

    public void clear() {
        this.itemsBeingCooked.clear();
    }

    public void spawnItemsBeingCooked() {
        if (!Objects.requireNonNull(this.getWorld()).isClient) {
            ItemScatterer.spawn(this.getWorld(), this.getPos(), this.getItemsBeingCooked());
        }

        this.updateListeners();
    }
}
