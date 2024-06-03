package com.baakun.feux.commands

import com.baakun.feux.Feux.Companion.anchors
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object Anchors : CommandExecutor {
    override fun onCommand(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>?,
    ): Boolean {
        val show = p3?.getOrNull(0) != "hide"
        anchors.flatten().forEach {
            it.block.type = if (show) Material.PEARLESCENT_FROGLIGHT else Material.AIR
        }
        return true
    }
}
