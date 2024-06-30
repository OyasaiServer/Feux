package com.baakun.feux.commands

import com.baakun.feux.StageManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object Start : CommandExecutor {
    override fun onCommand(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>?,
    ): Boolean {
        val scriptName = p3?.getOrNull(0) ?: return false
        StageManager.start(scriptName)
        return true
    }
}
