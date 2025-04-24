package com.hcgstudio.reninjacraft.event

import com.hcgstudio.reninjacraft.payload.EventPayload
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Event {
    private val module = SerializersModule {
        polymorphic(ServerToClientEvent::class) {
            subclass(SyncNinjutsuEvent::class)
        }

        polymorphic(ClientToServerEvent::class) {
            subclass(CastNinjutsuEvent::class)
        }
    }

    private val json = Json { serializersModule = module }

    fun parseServerToClientEvent(data: String): ServerToClientEvent {
        return json.decodeFromString(data)
    }

    fun parseClientToServerEvent(data: String): ClientToServerEvent {
        return json.decodeFromString(data)
    }

    fun serializeEvent(event: ServerToClientEvent): String {
        return json.encodeToString(event)
    }

    fun serializeEvent(event: ClientToServerEvent): String {
        return json.encodeToString(event)
    }

    fun pack(event: ClientToServerEvent): EventPayload {
        return EventPayload(serializeEvent(event))
    }

    fun pack(event: ServerToClientEvent): EventPayload {
        return EventPayload(serializeEvent(event))
    }
}
