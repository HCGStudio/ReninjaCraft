package com.hcgstudio.reninjacraft.registry

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text

object ReninjaItemGroups {
    private val reninjaItemGroups = mutableMapOf<String, ItemGroup>()

    operator fun get(key: String): ItemGroup? {
        return reninjaItemGroups[key]
    }

    fun initialize() {
        ReninjaCraft.logger.info("Initializing item groups")

        reninjaItemGroups.put("reninja_group", register("reninja_group", "rekara"))
    }

    private fun register(
        name: String,
        icon: String = name,
    ): ItemGroup {
        val itemGroup = FabricItemGroup.builder()
            .icon { ItemStack(ReninjaItems.reninjaItems[icon]!!) }
            .displayName(Text.translatable("itemGroup.${ReninjaCraft.MOD_ID}.${name}"))
            .build()

        return Registry.register(Registries.ITEM_GROUP, ReninjaCraft.itemGroupKeyOf(name), itemGroup)
    }
}
