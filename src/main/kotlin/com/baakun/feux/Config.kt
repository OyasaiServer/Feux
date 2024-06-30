package com.baakun.feux

import com.baakun.feux.Feux.Companion.plugin

object Config {
    private val config = plugin.config

    object Firework {
        val INTERVAL = config.getInt("firework.interval")
        val WINGS = config.getInt("firework.wings")
        val VIRTICAL_OFFSET = config.getInt("firework.vertical_offset")
    }
}
