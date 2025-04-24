package com.hcgstudio.reninjacraft.providers

import com.hcgstudio.reninjacraft.ReninjaCraft
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class DefaultLangProvider(
    dataOutput: FabricDataOutput, registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricLanguageProvider(dataOutput, "zh_cn", registryLookup) {

    override fun generateTranslations(
        wrapperLookup: RegistryWrapper.WrapperLookup?, translationBuilder: TranslationBuilder
    ) {
        translationBuilder.add("jade.modName.${ReninjaCraft.MOD_ID}", "蕾忍工艺")
        translationBuilder.add("modmenu.nameTranslation.${ReninjaCraft.MOD_ID}", "蕾忍工艺")

        translationBuilder.add("itemGroup.${ReninjaCraft.MOD_ID}.reninja_group", "蕾忍工艺")
        translationBuilder.add("item.${ReninjaCraft.MOD_ID}.rekara", "蕾珂拉")
        translationBuilder.add("item.${ReninjaCraft.MOD_ID}.rekara_ore", "蕾珂拉矿")
        translationBuilder.add("item.${ReninjaCraft.MOD_ID}.deepslate_rekara_ore", "深层蕾珂拉矿")

        translationBuilder.add("hud.${ReninjaCraft.MOD_ID}.hand_hud_text", "手：%1\$s/%2\$s")
        translationBuilder.add("hud.${ReninjaCraft.MOD_ID}.rekara_hud_text", "蕾珂拉：%1\$s/%2\$s")

        translationBuilder.add("commands.${ReninjaCraft.MOD_ID}.setrekara.success", "已将%1\$s的蕾珂拉设置为%2\$s")
    }
}
