package com.hcgstudio.reninjacraft.ninjutsu

import com.hcgstudio.reninjacraft.ReninjaCraft
import com.hcgstudio.reninjacraft.event.SyncNinjutsuEvent
import com.hcgstudio.reninjacraft.event.SyncedNinjutsu
import com.hcgstudio.reninjacraft.payload.EventPayload
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking

object NinjutsuRegistry {
    private val ninjutsuMap = mutableMapOf<String, Ninjutsu>()

    val allNinjutsu: Collection<Ninjutsu>
        get() = ninjutsuMap.values

    fun registerNinjutsu(name: String, ninjutsu: Ninjutsu) {
        ninjutsuMap.put(name, ninjutsu)
    }

    fun initialize() {
        ReninjaCraft.logger.info("Initializing ninjutsu registry")

        registerNinjutsu("shake_shake_hand", ShakeShakeHand())

        ServerPlayConnectionEvents.JOIN.register { handler, sender, server ->
            val player = handler.player

            ServerPlayNetworking.send(
                player,
                EventPayload.create(
                    SyncNinjutsuEvent(ninjutsuMap.map { entry ->
                        SyncedNinjutsu(
                            entry.key,
                            entry.value.castSequence,
                            entry.value.soundId
                        )
                    })
                )
            )
        }
    }
}
