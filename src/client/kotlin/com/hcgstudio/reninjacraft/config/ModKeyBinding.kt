package com.hcgstudio.reninjacraft.config

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

object ModKeyBinding {
    lateinit var upKey: KeyBinding
    lateinit var downKey: KeyBinding
    lateinit var leftKey: KeyBinding
    lateinit var rightKey: KeyBinding


    fun initialize() {
        upKey = KeyBinding(
            "key.${ReninjaCraft.MOD_ID}.up",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_W,
            "category.${ReninjaCraft.MOD_ID}.ninjutsu_cast"
        )

        downKey = KeyBinding(
            "key.${ReninjaCraft.MOD_ID}.down",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_S,
            "category.${ReninjaCraft.MOD_ID}.ninjutsu_cast"
        )

        leftKey = KeyBinding(
            "key.${ReninjaCraft.MOD_ID}.left",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_A,
            "category.${ReninjaCraft.MOD_ID}.ninjutsu_cast"
        )

        rightKey = KeyBinding(
            "key.${ReninjaCraft.MOD_ID}.right",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_D,
            "category.${ReninjaCraft.MOD_ID}.ninjutsu_cast"
        )

        KeyBindingHelper.registerKeyBinding(upKey)
        KeyBindingHelper.registerKeyBinding(downKey)
        KeyBindingHelper.registerKeyBinding(rightKey)
        KeyBindingHelper.registerKeyBinding(leftKey)

    }
}
