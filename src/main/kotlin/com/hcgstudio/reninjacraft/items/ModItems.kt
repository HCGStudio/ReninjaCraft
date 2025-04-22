package com.hcgstudio.reninjacraft.items

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

object ModItems {
    private val reninjaCommonItems = listOf("rekara")
    private val reninjaBlockItems = listOf("rekara_ore", "deepslate_rekara_ore")

    val reninjaItems = mutableMapOf<String, Item>()

    fun initialize() {
        ReninjaCraft.logger.info("Initializing items")

        reninjaItems.putAll(reninjaCommonItems.associateWith { register(it, Item.Settings()) })
        reninjaItems.putAll(reninjaBlockItems.associateWith { registerBlockItems(it, Item.Settings()) })

        ItemGroupEvents.modifyEntriesEvent(ReninjaCraft.itemGroupKeyOf("reninja_group"))
            .register { reninjaItems.values.forEach { item -> it.add(item) } }
    }

    private fun register(
        name: String,
        settings: Item.Settings
    ): Item {
        val itemKey = ReninjaCraft.itemKeyOf(name)
        val item = Item(settings.registryKey(itemKey))
        Registry.register(Registries.ITEM, itemKey, item)
        return item
    }

    private fun registerBlockItems(
        name: String,
        settings: Item.Settings
    ): Item {
        val itemKey = ReninjaCraft.itemKeyOf(name)
        val blockItem = BlockItem(ModBlocks.reninjaBlocks[name]!!, settings.registryKey(itemKey))
        return Registry.register(Registries.ITEM, itemKey, blockItem)
    }

}
