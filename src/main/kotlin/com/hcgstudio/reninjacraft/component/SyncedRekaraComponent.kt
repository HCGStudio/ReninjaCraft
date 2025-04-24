package com.hcgstudio.reninjacraft.component

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.SharedConstants.TICKS_PER_SECOND
import net.minecraft.entity.Entity
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper
import org.ladysnake.cca.api.v3.component.ComponentRegistry
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent

class SyncedRekaraComponent(val provider: Entity) : RekaraComponent, HandComponent, AutoSyncedComponent {
    companion object {
        val key = ReninjaCraft.keyOf("rekara")
        val componentKey = ComponentRegistry.getOrCreate(key, RekaraComponent::class.java)!!

        var tickCounter = 0

        fun initialize() {
            ServerTickEvents.END_SERVER_TICK.register {
                tickCounter++

                if (tickCounter >= TICKS_PER_SECOND) {
                    tickCounter = 0
                    it.playerManager.playerList.forEach { player ->
                        val rekaraComponent = componentKey.get(player)
                        rekaraComponent.rekara += 0F
                    }
                }
            }
        }
    }

    override var rekara: Float = 0F
        set(value) {
            field = value
            componentKey.sync(provider)
        }

    override var maxRekara = 100F
        set(value) {
            field = value
            componentKey.sync(provider)
        }

    override var hand: Int = 2
        set(value) {
            field = value
            componentKey.sync(provider)
        }

    override var maxHand: Int = 2
        set(value) {
            field = value
            componentKey.sync(provider)
        }

    override fun readFromNbt(
        tag: NbtCompound,
        lookup: RegistryWrapper.WrapperLookup
    ) {
        rekara = tag.getFloat("rekara").get()
        maxRekara = tag.getFloat("maxRekara").get()
        hand = tag.getInt("hand").get()
        maxHand = tag.getInt("maxHand").get()
    }

    override fun writeToNbt(
        tag: NbtCompound,
        lookup: RegistryWrapper.WrapperLookup
    ) {
        tag.putFloat("rekara", rekara)
        tag.putFloat("maxRekara", maxRekara)
        tag.putInt("hand", hand)
        tag.putInt("maxHand", maxHand)
    }
}
