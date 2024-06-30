package com.baakun.feux.commands

import com.baakun.feux.Config
import com.baakun.feux.scripts.firework.Firework
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.command.BlockCommandSender
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.concurrent.atomic.AtomicBoolean

object Anchor : CommandExecutor {
    private val debug = AtomicBoolean()

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?,
    ): Boolean {
        if (sender is BlockCommandSender) {
            val direction = args?.getOrNull(0)?.lowercase() ?: return false
            val blockFace = BlockFace.entries.find { it.name.lowercase() == direction } ?: return false
            Firework.setAnchors(
                generateAnchors(sender.block.location, blockFace)
            )
            return true
        }
        if (sender is Player) {
            debug.get().let {
                debug.set(!it)
                Firework.anchors.forEach { anchor ->
                    anchor.block.type = if (it) {
                        Material.AIR
                    } else {
                        Material.PEARLESCENT_FROGLIGHT
                    }
                }
            }
        }
        return true
    }

    private fun generateAnchors(
        initial: Location,
        blockFace: BlockFace,
    ): List<Location> = (0..Config.Firework.WINGS * 2).map {
        initial.clone().apply {
            add(0.0, Config.Firework.VIRTICAL_OFFSET.toDouble(), 0.0)
            val delta = ((it - Config.Firework.WINGS) * (Config.Firework.INTERVAL + 1)).toDouble()
            if (blockFace.modX == 0) {
                add(delta, 0.0, 0.0)
            } else {
                add(0.0, 0.0, delta)
            }
        }
    }
}
