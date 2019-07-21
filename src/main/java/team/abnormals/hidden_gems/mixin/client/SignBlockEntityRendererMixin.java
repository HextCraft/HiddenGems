package team.abnormals.hidden_gems.mixin.client;

import net.minecraft.block.Block;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import team.abnormals.hidden_gems.HiddenGems;

@Mixin(SignBlockEntityRenderer.class)
public class SignBlockEntityRendererMixin {

    @Inject(method = "getModelTexture(Lnet/minecraft/block/Block;)Lnet/minecraft/util/Identifier;", at = @At("RETURN"), cancellable = true)
    private void getModelTexture(Block block_1, CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        HiddenGems.SIGN_TEXTURES.forEach((baseSignBlockBaseWallSignBlockMap, identifier) -> {
            baseSignBlockBaseWallSignBlockMap.forEach((signBlock, wallSignBlock) -> {
                if(block_1 == signBlock || block_1 == wallSignBlock) {
                    callbackInfoReturnable.setReturnValue(identifier);
                }
            });
        });
    }

}