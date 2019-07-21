package team.abnormals.hidden_gems.mixin.client.render.entity.feature;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import team.abnormals.hidden_gems.HiddenGems;
import team.abnormals.hidden_gems.init.HGItems;

@Mixin(ElytraFeatureRenderer.class)
public abstract class ElytraFeatureRendererMixin<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {

    @Shadow @Final private static Identifier SKIN;
    private static Identifier FEATHERED_ELYTRA_SKIN = new Identifier(HiddenGems.MOD_ID, "textures/entity/elytra/feathered_elytra.png");
    private static Identifier PHANTOM_ELYTRA_SKIN = new Identifier(HiddenGems.MOD_ID, "textures/entity/elytra/phantom_elytra.png");
    @Shadow @Final private ElytraEntityModel<T> elytra;

    public ElytraFeatureRendererMixin(FeatureRendererContext<T, M> featureRendererContext_1) {
        super(featureRendererContext_1);
    }

    /**
     * @author OliviaTheVampire
     */
    @Overwrite
    public void method_17161(T livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6, float float_7) {
        ItemStack itemStack_1 = livingEntity_1.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack_1.getItem() instanceof ElytraItem) {
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (livingEntity_1 instanceof AbstractClientPlayerEntity) {
                AbstractClientPlayerEntity abstractClientPlayerEntity_1 = (AbstractClientPlayerEntity) livingEntity_1;
                if (itemStack_1.getItem() != HGItems.FEATHERED_ELYTRA || itemStack_1.getItem() != HGItems.PHANTOM_ELYTRA) {
                    if (abstractClientPlayerEntity_1.canRenderElytraTexture() && abstractClientPlayerEntity_1.getElytraTexture() != null) {
                        this.bindTexture(abstractClientPlayerEntity_1.getElytraTexture());
                    } else if (abstractClientPlayerEntity_1.canRenderCapeTexture() && abstractClientPlayerEntity_1.getCapeTexture() != null && abstractClientPlayerEntity_1.isSkinOverlayVisible(PlayerModelPart.CAPE)) {
                        this.bindTexture(abstractClientPlayerEntity_1.getCapeTexture());
                    } else {
                        if (itemStack_1.getItem() == HGItems.PHANTOM_ELYTRA) {
                            this.bindTexture(PHANTOM_ELYTRA_SKIN);
                        } else if (itemStack_1.getItem() == HGItems.FEATHERED_ELYTRA) {
                            this.bindTexture(FEATHERED_ELYTRA_SKIN);
                        } else {
                            this.bindTexture(SKIN);
                        }
                    }
                }
            } else {
                this.bindTexture(SKIN);
            }

            GlStateManager.pushMatrix();
            GlStateManager.translatef(0.0F, 0.0F, 0.125F);
            this.elytra.method_17079(livingEntity_1, float_1, float_2, float_4, float_5, float_6, float_7);
            this.elytra.method_17078(livingEntity_1, float_1, float_2, float_4, float_5, float_6, float_7);
            if (itemStack_1.hasEnchantments()) {
                ArmorFeatureRenderer.renderEnchantedGlint(this::bindTexture, livingEntity_1, this.elytra, float_1, float_2, float_3, float_4, float_5, float_6, float_7);
            }

            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
}
