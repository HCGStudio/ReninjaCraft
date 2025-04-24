package com.hcgstudio.reninjacraft.event

import com.hcgstudio.reninjacraft.ninjutsu.NinjutsuKeys
import kotlinx.serialization.Serializable

@Serializable
data class SyncedNinjutsu(val name: String, val castSequence: List<NinjutsuKeys>, val soundId: String)
