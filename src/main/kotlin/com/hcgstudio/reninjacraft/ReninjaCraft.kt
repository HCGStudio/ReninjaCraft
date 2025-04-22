package com.hcgstudio.reninjacraft

import com.hcgstudio.reninjacraft.items.ModBlocks
import com.hcgstudio.reninjacraft.items.ModItemGroups
import com.hcgstudio.reninjacraft.items.ModItems
import com.hcgstudio.reninjacraft.items.ModSounds
import com.hcgstudio.reninjacraft.world.ModOreGeneration
import net.fabricmc.api.ModInitializer
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature
import org.slf4j.LoggerFactory


object ReninjaCraft : ModInitializer {
    const val MOD_ID = "reninjacraft"
    val logger = LoggerFactory.getLogger("ReninjaCraft")!!

    fun keyOf(name: String): Identifier {
        return Identifier.of(MOD_ID, name)
    }

    fun itemKeyOf(name: String): RegistryKey<Item> {
        return RegistryKey.of(Registries.ITEM.key, keyOf(name))
    }

    fun blockKeyOf(name: String): RegistryKey<Block> {
        return RegistryKey.of(Registries.BLOCK.key, keyOf(name))
    }

    fun itemGroupKeyOf(name: String): RegistryKey<ItemGroup> {
        return RegistryKey.of(Registries.ITEM_GROUP.key, keyOf(name))
    }

    fun placedKeyOf(name: String): RegistryKey<PlacedFeature> {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, keyOf(name))
    }


    override fun onInitialize() {
        logger.debug("Start initializing ReninjaCraft")
        ModBlocks.initialize()
        ModItemGroups.initialize()
        ModItems.initialize()

        ModOreGeneration.initialize()

        ModSounds.initialize()
    }
}
