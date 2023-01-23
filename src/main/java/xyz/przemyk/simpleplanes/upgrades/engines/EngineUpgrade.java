package xyz.przemyk.simpleplanes.upgrades.engines;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.HumanoidArm;
import xyz.przemyk.simpleplanes.entities.PlaneEntity;
import xyz.przemyk.simpleplanes.upgrades.Upgrade;
import xyz.przemyk.simpleplanes.upgrades.UpgradeType;

public abstract class EngineUpgrade extends Upgrade {

    public EngineUpgrade(UpgradeType type, PlaneEntity planeEntity) {
        super(type, planeEntity);
    }

    @Override
    public void remove() {
        super.remove();
        planeEntity.engineUpgrade = null;
    }

    public abstract boolean isPowered();
    public abstract void renderPowerHUD(PoseStack matrixStack, HumanoidArm side, int scaledWidth, int scaledHeight, float partialTicks);
}
