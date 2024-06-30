package com.baakun.feux

import com.baakun.feux.Broadcaster.adminBroadcast
import com.baakun.feux.Feux.Companion.plugin
import org.bukkit.scheduler.BukkitTask

object StageManager {
    private val scripts = mutableListOf<Script>()
    private val liveScripts = mutableMapOf<String, BukkitTask>()

    fun load(vararg scripts: Script) {
        this.scripts.addAll(scripts)
    }

    fun start(scriptName: String) = requireNotNull(scripts.find {
        it::class.simpleName == scriptName
    }) {
        adminBroadcast("Script $scriptName not found")
        return
    }.run {
        adminBroadcast("Starting script $scriptName")
        liveScripts[scriptName] = plugin.server.scheduler.runTaskAsynchronously(
            plugin,
            Runnable {
                start()
            }
        )
    }

    fun end(scriptName: String): Unit = liveScripts.getOrElse(scriptName) {
        adminBroadcast("Script $scriptName not found")
        return
    }.run {
        adminBroadcast("Ending script $scriptName")
        cancel()
        liveScripts.remove(scriptName)
    }

    fun close() = liveScripts.run {
        forEach { (name, script) ->
            adminBroadcast("Ending script $name")
            script.cancel()
        }
        clear()
    }
}
