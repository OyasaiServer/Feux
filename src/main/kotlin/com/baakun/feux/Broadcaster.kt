package com.baakun.feux

import com.baakun.feux.Feux.Companion.plugin
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title

object Broadcaster {
    fun adminBroadcast(message: String) {
        plugin.server.onlinePlayers.filter { it.isOp }.forEach {
            it.sendMessage(message)
        }
    }

    fun broadcast(message: String) {
        plugin.server.broadcast(Component.text(message))
    }

    fun broardcast(title: Title) {
        plugin.server.onlinePlayers.forEach {
            it.showTitle(title)
        }
    }
}
