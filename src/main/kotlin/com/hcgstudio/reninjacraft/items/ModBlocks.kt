package com.hcgstudio.reninjacraft.items

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.math.intprovider.UniformIntProvider
import java.util.function.Function

object ModBlocks {
    val reninjaBlocks = mutableMapOf<String, Block>()

    fun initialize() {
        ReninjaCraft.logger.info("Initializing blocks")

        register(
            "rekara_ore",
            { ExperienceDroppingBlock(UniformIntProvider.create(3, 7), it) },
            AbstractBlock.Settings
                .copy(Blocks.DEEPSLATE_DIAMOND_ORE)
        )

        register(
            "deepslate_rekara_ore",
            { ExperienceDroppingBlock(UniformIntProvider.create(3, 7), it) },
            AbstractBlock.Settings
                .copy(Blocks.DEEPSLATE_DIAMOND_ORE)
        )
    }

    private fun register(
        name: String,
        blockFactory: Function<AbstractBlock.Settings, Block>,
        settings: AbstractBlock.Settings,
    ): Block {
        val blockKey = ReninjaCraft.blockKeyOf(name)
        val block = blockFactory.apply(settings.registryKey(blockKey))
        reninjaBlocks.put(name, block)
        return Registry.register(Registries.BLOCK, blockKey, block)
    }
}
