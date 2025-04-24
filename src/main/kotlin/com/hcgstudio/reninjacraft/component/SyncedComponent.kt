package com.hcgstudio.reninjacraft.component

import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy

object SyncedComponent : EntityComponentInitializer {
    override fun registerEntityComponentFactories(registry: EntityComponentFactoryRegistry) {
        registry.registerForPlayers(
            SyncedRekaraComponent.componentKey,
            ::SyncedRekaraComponent,
            RespawnCopyStrategy.ALWAYS_COPY
        )
    }
}
