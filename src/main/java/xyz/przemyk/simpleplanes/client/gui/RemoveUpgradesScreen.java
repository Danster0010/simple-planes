package xyz.przemyk.simpleplanes.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import xyz.przemyk.simpleplanes.client.UpgradeButtonsList;
import xyz.przemyk.simpleplanes.container.RemoveUpgradesContainer;
import xyz.przemyk.simpleplanes.entities.PlaneEntity;

public class RemoveUpgradesScreen extends AbstractContainerScreen<RemoveUpgradesContainer> {

    private UpgradeButtonsList buttonsList;

    public RemoveUpgradesScreen(RemoveUpgradesContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void init() {
        super.init();
        Entity entity = minecraft.level.getEntity(menu.planeID);
        if (entity instanceof PlaneEntity) {
            buttonsList = new UpgradeButtonsList(minecraft, 120, height, 32, height - 61, 20, (PlaneEntity) entity);
            addRenderableWidget(buttonsList);
        } else {
            onClose();
        }
    }

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int x, int y) {}
    @Override
    protected void renderLabels(PoseStack matrixStack, int x, int y) {}

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        buttonsList.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}
