package com.hcgstudio.reninjacraft

import com.hcgstudio.reninjacraft.items.ModBlocks
import com.hcgstudio.reninjacraft.items.ModItemGroups
import com.hcgstudio.reninjacraft.items.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry.register
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory


object ReninjaCraft : ModInitializer {
    const val MOD_ID = "reninjacraft"
    private val logger = LoggerFactory.getLogger("reninja-craft")

    fun keyOf(name: String): Identifier {
        return Identifier.of(MOD_ID, name)
    }

    fun itemKeyOf(name: String): RegistryKey<Item> {
        return RegistryKey.of(Registries.ITEM.key, keyOf(name))
    }

    fun blockKeyOf(name: String) : RegistryKey<Block> {
        return RegistryKey.of(Registries.BLOCK.key, keyOf(name))
    }

    fun itemGroupKeyOf(name: String) : RegistryKey<ItemGroup> {
        return RegistryKey.of(Registries.ITEM_GROUP.key, keyOf(name))
    }


    override fun onInitialize() {
        logger.info("Hello Fabric world!")

        ModBlocks.initialize()
        ModItemGroups.initialize()
        ModItems.initialize()
//        BiomeModifications.addFeature(
//            BiomeSelectors.foundInOverworld(),
//            GenerationStep.Feature.UNDERGROUND_ORES,
//            RegistryKeys.PLACED_FEATURE.value(Identifier(MOD_ID, ""))
//        )
    }
}
