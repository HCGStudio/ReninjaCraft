package com.hcgstudio.reninjacraft.casting

import com.hcgstudio.reninjacraft.ReninjaCraftClient
import com.hcgstudio.reninjacraft.client.ClientNinjutsuRegistry
import com.hcgstudio.reninjacraft.items.ModSounds
import com.hcgstudio.reninjacraft.ninjutsu.NinjutsuKeys
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.minecraft.client.sound.PositionedSoundInstance
import org.lwjgl.glfw.GLFW

object NinjutsuCastHandler {
    val castingInputQueue = mutableListOf<NinjutsuKeys>()
    var wPressed = false
    var aPressed = false
    var sPressed = false
    var dPressed = false

    fun initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick {
            // TODO: Add option to press ctrl once, arrow then cast
            it.world ?: return@EndTick

            val isCtrlDown = GLFW.glfwGetKey(
                it.window.handle,
                GLFW.GLFW_KEY_LEFT_CONTROL
            ) == GLFW.GLFW_PRESS || GLFW.glfwGetKey(it.window.handle, GLFW.GLFW_KEY_RIGHT_CONTROL) == GLFW.GLFW_PRESS

            if (!isCtrlDown && castingInputQueue.isNotEmpty()) {
                val ninjutsu = ClientNinjutsuRegistry.getSyncedNinjutsu(castingInputQueue)
                castingInputQueue.clear()

                if (ninjutsu == null) {
                    return@EndTick
                }

                ModSounds.reninjaSounds[ninjutsu.soundId]?.run {
                    val sound = PositionedSoundInstance.master(
                        this,
                        1.0f
                    )
                    it.soundManager.play(sound)
                }

                ReninjaCraftClient.logger.info("Casting ${ninjutsu.name}")
            }

            if (!isCtrlDown)
                return@EndTick

            val wPressing = GLFW.glfwGetKey(
                it.window.handle,
                GLFW.GLFW_KEY_W
            ) == GLFW.GLFW_PRESS

            val aPressing = GLFW.glfwGetKey(
                it.window.handle,
                GLFW.GLFW_KEY_A
            ) == GLFW.GLFW_PRESS

            val sPressing = GLFW.glfwGetKey(
                it.window.handle,
                GLFW.GLFW_KEY_S
            ) == GLFW.GLFW_PRESS

            val dPressing = GLFW.glfwGetKey(
                it.window.handle,
                GLFW.GLFW_KEY_D
            ) == GLFW.GLFW_PRESS

            if (wPressing) {
                if (!wPressed) {
                    wPressed = true
                    ReninjaCraftClient.logger.info("Ctrl+Up key pressed")
                    castingInputQueue.add(NinjutsuKeys.Up)
                }
            } else {
                wPressed = false
            }

            if (aPressing) {
                if (!aPressed) {
                    aPressed = true
                    ReninjaCraftClient.logger.info("Ctrl+Left key pressed")
                    castingInputQueue.add(NinjutsuKeys.Left)
                }
            } else {
                aPressed = false
            }

            if (sPressing) {
                if (!sPressed) {
                    sPressed = true
                    ReninjaCraftClient.logger.info("Ctrl+Down key pressed")
                    castingInputQueue.add(NinjutsuKeys.Down)
                }
            } else {
                sPressed = false
            }

            if (dPressing) {
                if (!dPressed) {
                    dPressed = true
                    ReninjaCraftClient.logger.info("Ctrl+Right key pressed")
                    castingInputQueue.add(NinjutsuKeys.Right)
                }
            } else {
                dPressed = false
            }
        })
    }


}
