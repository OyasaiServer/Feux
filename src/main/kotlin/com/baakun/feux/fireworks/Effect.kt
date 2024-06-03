package com.baakun.feux.fireworks

import org.bukkit.Color
import org.bukkit.FireworkEffect

enum class Effect(val instance: FireworkEffect) {
    COMMENCE_1_CENTER(
        FireworkEffect.builder()
            .with(FireworkEffect.Type.BALL_LARGE)
            .withColor(Color.WHITE, Color.AQUA)
            .build(),
    ),
    COMMENCE_1_BURST(
        FireworkEffect.builder()
            .with(FireworkEffect.Type.BURST)
            .withColor(Color.LIME, Color.WHITE)
            .withFlicker()
            .build(),
    ),
    COMMENCE_1_SUB(
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
