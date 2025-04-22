package com.hcgstudio.reninjacraft

import com.hcgstudio.reninjacraft.providers.DefaultLangProvider
import com.hcgstudio.reninjacraft.providers.DefaultModelProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object ReninjaCraftDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()
        pack.addProvider(::DefaultLangProvider)
        pack.addProvider(::DefaultModelProvider)
    }
}
