package com.baakun.feux.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object Test : CommandExecutor {
    override fun onCommand(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>?,
    ): Boolean {
//        val location = LocationSafe((p0 as Player).location)
//        ParticleText(
//            ParticleHappy(),
//            location,
//            30.0,
//            10.0,
//            "Oyasai Server",
//        ).apply {
//            setAroundAxisPitch(location, 90.0)
//            display()
//        }
//        println("HEART PARTICLE DISPLAYED!")
        listOf(cond1(), cond2()).reduce(Boolean::and)
        return true
    }

    fun cond1(): Boolean {
        return true
    }

    fun cond2(): Boolean {
        return true
    }
}
