package com.srgnis.testhud.callback;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

import static java.lang.Math.*;
import static net.minecraft.client.gui.DrawableHelper.fill;

@Environment(EnvType.CLIENT)
public class FirstAidCallBack implements HudRenderCallback{
    int green = 0xff8fce00;
    int red = 0xffb70000;
    int black = 0xff191919;
    @Override
    public void onHudRender(MatrixStack matrixStack, float v) {
        matrixStack.push();
            fill(matrixStack, 10, 0, 30, 20, black);
            fill(matrixStack, 12, 2, 28, 18, green);
            //arm
            fill(matrixStack, 0, 20, 10, 50, black);
            fill(matrixStack, 2, 22, 8, 48, green);
            //body
            fill(matrixStack, 10, 20, 30, 50, black);
            fill(matrixStack, 12, 22, 28, 48, green);
            //arm
            fill(matrixStack, 30, 20, 40, 50, black);
            fill(matrixStack, 32, 22, 38, 48, green);
            //legs
            fill(matrixStack, 10, 50, 20, 70, black);
            fill(matrixStack, 12, 52, 18, 68, green);
            fill(matrixStack, 20, 50, 30, 70, black);
            fill(matrixStack, 22, 52, 28, 68, green);
            //foot
            fill(matrixStack, 10, 70, 20, 80, black);
            fill(matrixStack, 12, 72, 18, 78, green);
            fill(matrixStack, 20, 70, 30, 80, black);
            fill(matrixStack, 22, 72, 28, 78, green);
        matrixStack.pop();
    }

}
