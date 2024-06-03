package com.baakun.feux.commands

import com.baakun.feux.Config
import com.baakun.feux.Feux.Companion.anchor
import com.baakun.feux.Feux.Companion.anchors
import org.bukkit.Location
import org.bukkit.block.BlockFace
import org.bukkit.command.BlockCommandSender
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object Anchor : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?,
    ): Boolean {
        if (sender !is BlockCommandSender) {
            return false
        }
        val direction = args?.getOrNull(0)?.lowercase() ?: return false
        val blockFace = BlockFace.entries.find { it.name.lowercase() == direction } ?: return false
        anchor =
            sender.block.location.also {
                anchors = generateAnchors(it, blockFace)
            }
        return true
    }

    private fun generateAnchors(
        initial: Location,
        blockFace: BlockFace,
    ): List<List<Location>> {
        return (0 until Config.rows).map { rowIndex ->
            (0 until ((Config.wings * 2 + 1) - rowIndex % 2)).map { colIndex ->
                initial.clone().apply {
                    val diff = (Config.horizontalInterval + 1) * (colIndex - Config.wings).toDouble()
                    if (blockFace == BlockFace.NORTH || blockFace == BlockFace.SOUTH) {
                        add(
                            diff,
                            Config.horizontalOffset.toDouble(),
                            0.0,
                        )
                    } else {
                        add(
                            0.0,
                            Config.horizontalOffset.toDouble(),
                            diff,
                        )
                    }
                    if (rowIndex % 2 != 0) {
                        if (blockFace == BlockFace.NORTH || blockFace == BlockFace.SOUTH) {
                            add((Config.horizontalInterval + 1) / 2.0, 0.0, 0.0)
                        } else {
                            add(0.0, 0.0, (Config.horizontalInterval + 1) / 2.0)
                        }
                    }
                }.apply {
                    add(
                        (Config.verticalInterval * rowIndex * blockFace.modX).toDouble(),
                        (Config.verticalInterval * rowIndex * blockFace.modY).toDouble(),
                        (Config.verticalInterval * rowIndex * blockFace.modZ).toDouble(),
                    )
                }
            }
        }
    }
}
