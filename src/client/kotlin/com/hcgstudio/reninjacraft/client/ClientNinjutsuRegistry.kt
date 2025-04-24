package com.hcgstudio.reninjacraft.client

import com.hcgstudio.reninjacraft.event.SyncedNinjutsu
import com.hcgstudio.reninjacraft.ninjutsu.NinjutsuKeys

object ClientNinjutsuRegistry {
    private val ninjutsuMap = mutableMapOf<String, SyncedNinjutsu>()

    fun getSyncedNinjutsu(sequence: List<NinjutsuKeys>): SyncedNinjutsu? {
        return ninjutsuMap[sequence.joinToString(",")]
    }

    fun refreshSyncedNinjutsu(content: List<SyncedNinjutsu>) {
        ninjutsuMap.clear()
        ninjutsuMap.putAll(content.associateBy { it.castSequence.joinToString(",") })
    }
}
