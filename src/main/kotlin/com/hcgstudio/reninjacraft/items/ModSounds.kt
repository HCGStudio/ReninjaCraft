package com.hcgstudio.reninjacraft.items

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent

object ModSounds {
    private val soundList = listOf("scared_and_release_ninjutsu")

    val reninjaSounds = mutableMapOf<String, SoundEvent>()

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
