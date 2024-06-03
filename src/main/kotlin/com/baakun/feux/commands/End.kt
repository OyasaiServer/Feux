package com.baakun.feux.commands

import com.baakun.feux.Feux.Companion.tasks
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
        tasks.forEach {
            p0.sendMessage("Cancelling task ${it.taskId}")
            it.cancel()
        }
        tasks.clear()
        return true
    }
}
