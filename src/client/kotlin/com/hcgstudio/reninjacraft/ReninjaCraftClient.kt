package com.hcgstudio.reninjacraft

import com.hcgstudio.reninjacraft.items.ModSounds
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.MinecraftClient
import net.minecraft.client.gui.screen.TitleScreen
import net.minecraft.client.sound.PositionedSoundInstance
import org.slf4j.LoggerFactory

object ReninjaCraftClient : ClientModInitializer {
    val logger = LoggerFactory.getLogger("ReninjaCraft Client")!!
    private var hasPlayedMenuSound = false

    override fun onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register { client: MinecraftClient ->
            if (!hasPlayedMenuSound && client.currentScreen is TitleScreen) {
                val sound = PositionedSoundInstance.master(
                    ModSounds.reninjaSounds["scared_and_release_ninjutsu"]!!, // 你注册的自定义 SoundEvent
                    1.0f
                )
                client.soundManager.play(sound)
                logger.info("Playing init sound")
                hasPlayedMenuSound = true
            }
        }
    }
}
