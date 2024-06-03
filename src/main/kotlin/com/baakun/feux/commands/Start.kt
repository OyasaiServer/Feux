package com.baakun.feux.commands

import com.baakun.feux.Feux.Companion.feux
import com.baakun.feux.Feux.Companion.scripts
import com.baakun.feux.Feux.Companion.tasks
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
        val scriptName = p3?.getOrNull(0)
        val scriptsToRun =
            if (scriptName == null) scripts else listOfNotNull(scripts.find { it::class.simpleName == scriptName })
        if (scriptsToRun.isEmpty() && scriptName != null) {
            p0.sendMessage("Script $scriptName not found")
        } else {
            scriptsToRun.forEach { script ->
                val job =
                    feux.server.scheduler.runTaskAsynchronously(
                        feux,
                        Runnable {
                            script.run()
                        },
                    )
                tasks.add(job)
                p0.sendMessage("Starting script ${script::class.simpleName}")
            }
        }
        return true
    }
}
