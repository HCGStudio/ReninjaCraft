package com.hcgstudio.reninjacraft.payload

import com.hcgstudio.reninjacraft.ReninjaCraft
import com.hcgstudio.reninjacraft.event.Event
import com.hcgstudio.reninjacraft.event.SyncNinjutsuEvent
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.minecraft.network.RegistryByteBuf
import net.minecraft.network.codec.PacketCodec
import net.minecraft.network.codec.PacketCodecs
import net.minecraft.network.packet.CustomPayload

data class EventPayload(val content: String) : CustomPayload {
    companion object {
        private val packet = ReninjaCraft.keyOf("event_payload")

        val codec: PacketCodec<RegistryByteBuf, EventPayload> =
            PacketCodec.tuple(PacketCodecs.STRING, EventPayload::content, ::EventPayload)
        val id = CustomPayload.Id<EventPayload>(packet)

        fun initialize() {
            PayloadTypeRegistry.playS2C().register(id, codec)
        }

        fun create(event: SyncNinjutsuEvent): EventPayload {
            return EventPayload(Event.serializeEvent(event))
        }
    }

    override fun getId(): CustomPayload.Id<out CustomPayload?>? {
        return Companion.id
    }
}
