package com.hcgstudio.reninjacraft.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("cast_ninjutsu")
data class CastNinjutsuEvent(
    val name: String,
    val targetEntity: String?
) : ClientToServerEvent()
