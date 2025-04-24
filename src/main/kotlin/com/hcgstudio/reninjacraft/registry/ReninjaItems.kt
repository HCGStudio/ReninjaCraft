package com.hcgstudio.reninjacraft.registry

import com.hcgstudio.reninjacraft.ReninjaCraft
import com.hcgstudio.reninjacraft.item.RekaraRecoveryItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.component.type.FoodComponent
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

object ReninjaItems {
    private val reninjaCommonItems = emptyList<String>()
    private val reninjaBlockItems = listOf("rekara_ore", "deepslate_rekara_ore")

    val reninjaItems = mutableMapOf<String, Item>()

    fun initialize() {
        ReninjaCraft.logger.info("Initializing items")

        reninjaItems.putAll(reninjaCommonItems.associateWith { register(it, ::Item, Item.Settings()) })
        reninjaItems.putAll(reninjaBlockItems.associateWith {
            register(
                it,
                { settings -> BlockItem(ReninjaBlocks[it], settings) },
                Item.Settings()
            )
        })

        reninjaItems.put(
            "rekara",
            register(
                "rekara",
                { settings -> RekaraRecoveryItem(settings, 10) },
                Item.Settings()
                    .food(FoodComponent.Builder().alwaysEdible().build())
            )
        )

        ItemGroupEvents.modifyEntriesEvent(ReninjaCraft.itemGroupKeyOf("reninja_group"))
            .register { reninjaItems.values.forEach { item -> it.add(item) } }
    }

    private fun register(
        name: String,
        itemFactory: (Item.Settings) -> Item,
        settings: Item.Settings
    ): Item {
        val itemKey = ReninjaCraft.itemKeyOf(name)
        val item = itemFactory(settings.registryKey(itemKey))
        Registry.register(Registries.ITEM, itemKey, item)
        return item
    }
}
