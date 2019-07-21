package team.abnormals.hidden_gems.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import team.abnormals.hidden_gems.block.entity.LecternBlockEntity;
import team.abnormals.hidden_gems.client.renderer.AntelopeEntityRenderer;
import team.abnormals.hidden_gems.client.renderer.AxocordeEntityRenderer;
import team.abnormals.hidden_gems.client.renderer.LecternBlockEntityRenderer;
import team.abnormals.hidden_gems.entity.AntelopeEntity;
import team.abnormals.hidden_gems.entity.AxocordeEntity;

public class ClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(LecternBlockEntity.class, new LecternBlockEntityRenderer());

        EntityRendererRegistry.INSTANCE.register(AntelopeEntity.class, (dispatcher, context) -> new AntelopeEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AxocordeEntity.class, (dispatcher, context) -> new AxocordeEntityRenderer(dispatcher));
    }
}