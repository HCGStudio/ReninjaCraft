package com.hcgstudio.reninjacraft.world

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep

object ModOreGeneration {
    private val oreBlocks = listOf("ore_rekara")

    fun initialize() {
        ReninjaCraft.logger.info("Initializing ore generation")

        oreBlocks.forEach { registerOreGeneration(it) }
    }

    private fun registerOreGeneration(name: String) {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            ReninjaCraft.placedKeyOf(name)
        )
    }
}
