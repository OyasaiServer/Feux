package com.baakun.feux.fireworks

import com.baakun.feux.Config
import com.baakun.feux.Feux.Companion.feux
import org.bukkit.Location
import org.bukkit.entity.Firework

object Firework {
    fun launch(
        anchor: Location,
        fireworkEffect: Effect,
        height: Height,
    ) {
        feux.server.scheduler.runTask(
            feux,
            Runnable {
                val firework =
                    anchor.world.spawn(
                        anchor.apply {
                            y += Config.horizontalOffset
                        },
                        Firework::class.java,
                    ).apply {
                        fireworkMeta =
                            fireworkMeta.apply {
                                addEffect(fireworkEffect.instance)
                                power = 3
                            }
                    }
                feux.server.scheduler.runTaskLater(
                    feux,
                    Runnable {
                        firework.detonate()
                    },
                    height.ticksToDetonate,
                )
            },
        )
    }

    fun launch(
        anchors: List<Location>,
        fireworkEffect: Effect,
        height: Height,
    ) {
        anchors.forEach { anchor ->
            launch(anchor, fireworkEffect, height)
        }
    }
}
