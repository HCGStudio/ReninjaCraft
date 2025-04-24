package com.hcgstudio.reninjacraft.item

import com.hcgstudio.reninjacraft.component.SyncedRekaraComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import kotlin.math.min

class RekaraRecoveryItem(settings: Settings, val rekaraRecovery: Int) : Item(settings) {
    override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
        if (user is PlayerEntity) {
            val rekara = SyncedRekaraComponent.componentKey.get(user)
            rekara.rekara = min(rekara.maxRekara, rekara.rekara + rekaraRecovery)
        }

        return super.finishUsing(stack, world, user)
    }
}
