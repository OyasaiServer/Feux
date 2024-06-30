package com.baakun.feux.scripts.firework

import com.baakun.feux.Script
import com.baakun.feux.scripts.firework.acts.Intro
import org.bukkit.Location

object Firework : Script(Intro) {
    val anchors = mutableListOf<Location>()

    fun setAnchors(locations: List<Location>) {
        anchors.clear()
        anchors.addAll(locations)
    }

    enum class Height(val ticksToDetonate: Long) {
        R0(30L),
        R1(27L),
        R2(24L),
        R3(21L),
        R4(18L),
        R5(15L),
        R6(12L),
        R7(9L),
        R8(6L),
        R9(3L),
        R10(0L);
    }
}
