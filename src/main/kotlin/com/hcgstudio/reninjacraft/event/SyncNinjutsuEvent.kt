package com.hcgstudio.reninjacraft.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("sync_ninjutsu")
class SyncNinjutsuEvent(val ninjutsu: List<SyncedNinjutsu>) : ServerToClientEvent()
