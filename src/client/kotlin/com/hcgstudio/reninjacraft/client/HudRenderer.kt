package com.hcgstudio.reninjacraft.client

import com.hcgstudio.reninjacraft.ReninjaCraft
import com.hcgstudio.reninjacraft.component.SyncedRekaraComponent
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer
import net.minecraft.client.MinecraftClient
import net.minecraft.text.Text

object HudRenderer {
    val layerId = ReninjaCraft.keyOf("rekara_hud")

    fun initialize() {
        HudLayerRegistrationCallback.EVENT.register {
            it.attachLayerBefore(IdentifiedLayer.CHAT, layerId) { context, tickCounter ->
                val client = MinecraftClient.getInstance() ?: return@attachLayerBefore
                val player = client.player ?: return@attachLayerBefore
                val rekara = SyncedRekaraComponent.componentKey.get(player)

                val x = context.scaledWindowWidth / 2 + 10
                val y = context.scaledWindowHeight - 49 - 10

                context.drawText(
                    client.textRenderer,
                    Text.translatable("hud.${ReninjaCraft.MOD_ID}.hand_hud_text", rekara.hand, rekara.maxHand),
                    x,
                    y,
                    0xfde300,
                    true
                )

                context.drawText(
                    client.textRenderer,
                    Text.translatable("hud.${ReninjaCraft.MOD_ID}.rekara_hud_text", rekara.rekara, rekara.maxRekara),
                    x,
                    y + 10,
                    0x0e700e,
                    true
                )
            }
        }
    }
}
