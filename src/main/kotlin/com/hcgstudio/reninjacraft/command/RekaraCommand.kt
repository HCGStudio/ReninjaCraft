package com.hcgstudio.reninjacraft.command

import com.hcgstudio.reninjacraft.component.SyncedRekaraComponent
import com.mojang.brigadier.arguments.FloatArgumentType
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.argument.EntityArgumentType
import net.minecraft.server.command.CommandManager.argument
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.text.Text
import net.minecraft.util.Formatting

object RekaraCommand {
    fun initialize() {
        CommandRegistrationCallback.EVENT.register { dispatcher, registryAccess, environment ->
            dispatcher.register(
                literal("reninjacraft")
                    .then(
                        literal("setRekara")
                            .requires { it.hasPermissionLevel(2) }
                            .then(
                                argument("player", EntityArgumentType.player())
                                    .then(
                                        argument("count", FloatArgumentType.floatArg(0F))
                                            .executes {
                                                val player = EntityArgumentType.getPlayer(it, "player")
                                                val count = FloatArgumentType.getFloat(it, "count")
                                                val rekaraComponent = SyncedRekaraComponent.componentKey.get(player)
                                                rekaraComponent.rekara = count.coerceIn(0f, rekaraComponent.maxRekara)
                                                it.source.sendFeedback(
                                                    {
                                                        Text.translatable(
                                                            "commands.reninjacraft.setrekara.success",
                                                            player.name,
                                                            count
                                                        ).formatted(Formatting.GREEN)
                                                    },
                                                    true
                                                )
                                                0
                                            })
                            )

                    )
            )
        }
    }
}
