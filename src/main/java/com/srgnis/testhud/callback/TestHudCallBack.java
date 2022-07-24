package com.srgnis.testhud.callback;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

import static java.lang.Math.*;
import static net.minecraft.client.gui.DrawableHelper.fill;

public class TestHudCallBack implements HudRenderCallback{
    int green = 0xff8fce00;
    int red = 0xffb70000;
    double x;
    double z;
    boolean x_odd;
    boolean z_odd;
    @Override
    public void onHudRender(MatrixStack matrixStack, float v) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        TextRenderer renderer = MinecraftClient.getInstance().textRenderer;

        if (player != null) {
            x = (int)floor(player.getX());
            z = (int)floor(player.getZ());

            x_odd = (x % 2) != 0;
            z_odd = (z % 2) != 0;

            if(x_odd){
                fill(matrixStack, 1, 1, 10, 10, red);
            }else{
                fill(matrixStack, 1, 1, 10, 10, green);
            }

            if(z_odd){
                fill(matrixStack, 12, 1, 22, 10, red);
            }else{
                fill(matrixStack, 12, 1, 22, 10, green);
            }

            renderer.draw(matrixStack, String.format("X: %.0f | Z: %.0f",x ,z), 2.0F, 12.0F, 14737632);
        }
    }
}
