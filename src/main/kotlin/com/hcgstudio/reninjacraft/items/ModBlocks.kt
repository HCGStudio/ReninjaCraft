package com.hcgstudio.reninjacraft.items

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup

object ModBlocks {
    val reninjaBlocks = mutableMapOf<String, Block>()

    fun initialize() {
        register("rekara_ore" , AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE))
        register("deepslate_rekara_ore" , AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE))
    }

    private fun register(
        name: String,
        settings: AbstractBlock.Settings,
    ): Block {
        val blockKey = ReninjaCraft.blockKeyOf(name)
        val block = Block(settings.registryKey(blockKey))
        reninjaBlocks.put(name, block)
        return Registry.register(Registries.BLOCK, blockKey, block)
    }
}
