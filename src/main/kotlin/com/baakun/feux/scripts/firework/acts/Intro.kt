package com.baakun.feux.scripts.firework.acts

import com.baakun.feux.Script
import com.baakun.feux.scripts.firework.Firework.anchors
import com.baakun.feux.util.evens
import org.bukkit.Color
import org.bukkit.FireworkEffect

object Intro : Script.Act {
    override fun start() {
    }

    private enum class EffectLib(val effect: FireworkEffect) {
        CENTER(
            FireworkEffect.builder()
                .with(FireworkEffect.Type.BALL_LARGE)
                .withColor(Color.WHITE, Color.AQUA)
                .build(),
        ),
        BURST(
            FireworkEffect.builder()
                .with(FireworkEffect.Type.BURST)
                .withColor(Color.LIME, Color.WHITE)
                .withFlicker()
                .build(),
        ),
        SUB(
            FireworkEffect.builder()
                .with(FireworkEffect.Type.BURST)
                .withColor(Color.RED, Color.WHITE)
                .withFlicker()
                .withTrail()
                .build(),
        ),
        COMMENCE_2_CENTER(
            FireworkEffect.builder()
                .with(FireworkEffect.Type.STAR)
                .withColor(Color.WHITE, Color.YELLOW)
                .build(),
        ),
        COMMENCE_2_BURST(
            FireworkEffect.builder()
                .with(FireworkEffect.Type.BALL_LARGE)
                .withColor(Color.LIME, Color.WHITE)
                .withFlicker()
                .build(),
        ),
        COMMENCE_2_SUB(
            FireworkEffect.builder()
                .with(FireworkEffect.Type.BURST)
                .withColor(Color.OLIVE, Color.WHITE)
                .withFlicker()
                .withTrail()
                .build(),
        ),
    }
}
