package com.baakun.feux

import com.baakun.feux.commands.Anchor
import com.baakun.feux.commands.End
import com.baakun.feux.commands.Start
import com.baakun.feux.commands.Test
import com.baakun.feux.scripts.firework.Firework
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin

class Feux : JavaPlugin(), Logger {
    override fun onEnable() {
        saveConfig()
        registerCommands(Start, End, Anchor, Test)
        StageManager.load(Firework)
        logger.info("Feux has been enabled.")
    }

    private fun registerCommands(vararg commands: CommandExecutor) = commands.forEach {
        it::class.simpleName?.lowercase()?.let { name -> getCommand(name)?.setExecutor(it) }
    }

    companion object {
        val plugin by lazy { getPlugin(Feux::class.java) }
    }
}
