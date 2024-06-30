package com.baakun.feux.commands

import com.baakun.feux.StageManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object End : CommandExecutor {
    override fun onCommand(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>?,
    ): Boolean {
        val scriptName = p3?.getOrNull(0) ?: run {
            StageManager.close()
            return true
        }
        StageManager.end(scriptName)
        return true
    }
}
