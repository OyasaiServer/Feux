package com.baakun.feux

import com.baakun.feux.commands.*
import com.baakun.feux.scripts.Firework
import com.baakun.feux.scripts.Script
import hm.zelha.particlesfx.util.ParticleSFX
import org.bukkit.Location
import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitTask

@Suppress("unused")
class Feux : JavaPlugin(), Logger {
    override fun onEnable() {
        saveDefaultConfig()
        ParticleSFX.setPlugin(this)
        registerCommands(Start, End, Anchor, Anchors, Test)
    }

    private fun registerCommands(vararg commands: CommandExecutor) =
        commands.forEach {
            it::class.simpleName?.lowercase()?.let { name -> getCommand(name)?.setExecutor(it) }
        }

    companion object {
        val feux by lazy { getPlugin(Feux::class.java) }

        lateinit var anchor: Location
        lateinit var anchors: List<List<Location>>

        val tasks = mutableListOf<BukkitTask>()
        val scripts = listOf<Script>(Firework)
    }
}
