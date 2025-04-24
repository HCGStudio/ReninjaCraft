package com.hcgstudio.reninjacraft.client

import com.hcgstudio.reninjacraft.ReninjaCraftClient
import com.hcgstudio.reninjacraft.event.Event
import com.hcgstudio.reninjacraft.event.SyncNinjutsuEvent
import com.hcgstudio.reninjacraft.payload.EventPayload
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking

object ServerMessageHandler {
    fun initialize() {
        ClientPlayNetworking.registerGlobalReceiver(EventPayload.id, { payload, context ->
            val event = Event.parseServerToClientEvent(payload.content)

            ReninjaCraftClient.logger.info("Received event: {}", event)

            when (event) {
                is SyncNinjutsuEvent -> handleEvent(event, context)
            }
        })
    }

    fun handleEvent(event: SyncNinjutsuEvent, context: ClientPlayNetworking.Context) {
        ClientNinjutsuRegistry.refreshSyncedNinjutsu(event.ninjutsu)
    }
}
