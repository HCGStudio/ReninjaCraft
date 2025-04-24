package com.hcgstudio.reninjacraft.registry

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent

object ReninjaSounds {
    private val soundList = listOf("scared_and_release_ninjutsu", "shake_shake_hand")

    private val reninjaSounds = mutableMapOf<String, SoundEvent>()

    operator fun get(key: String): SoundEvent? {
        return reninjaSounds[key]
    }

    fun initialize() {
        ReninjaCraft.logger.info("Initializing sounds")

        reninjaSounds.putAll(soundList.associateWith { register(it) })
    }

    private fun register(name: String): SoundEvent {
        val soundKey = ReninjaCraft.keyOf(name)
        val soundEvent = SoundEvent.of(soundKey)
        return Registry.register(Registries.SOUND_EVENT, soundKey, soundEvent)
    }
}
