package com.baakun.feux

import com.baakun.feux.Feux.Companion.feux
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title

object Util {
    fun adminBroadcast(message: String) {
        feux.server.onlinePlayers.filter { it.isOp }.forEach {
            it.sendMessage(message)
        }
    }

    fun broadcast(message: String) {
        feux.server.broadcast(Component.text(message))
    }

    fun broardcast(title: Title) {
        feux.server.onlinePlayers.forEach {
            it.showTitle(title)
        }
    }
}
