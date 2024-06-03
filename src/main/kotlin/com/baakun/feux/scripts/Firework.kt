package com.baakun.feux.scripts

import com.baakun.feux.Feux.Companion.anchors
import com.baakun.feux.Util.broardcast
import com.baakun.feux.fireworks.Effect
import com.baakun.feux.fireworks.Firework.launch
import com.baakun.feux.fireworks.Height
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.title.Title.Times.times
import net.kyori.adventure.title.Title.title
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

object Firework : Script {
    override fun run() {
        commencement()
    }

    private fun commencement() {
        broardcast(
            title(
                text("おやさいサーバー"),
                text("５周年記念"),
                times(
                    1.seconds.toJavaDuration(),
                    4.seconds.toJavaDuration(),
                    1.seconds.toJavaDuration(),
                ),
            ),
        )
        sleep(1.seconds)
        launch(
            anchors[0].filterIndexed { i, _ -> i % 2 == 0 },
            Effect.COMMENCE_1_CENTER,
            Height.R0,
        )
        launch(
            anchors[0].filterIndexed { i, _ -> i % 2 == 1 },
            Effect.COMMENCE_1_BURST,
            Height.R0,
        )
        launch(anchors[1], Effect.COMMENCE_1_SUB, Height.R5)

        sleep(6.seconds)

        broardcast(
            title(
                text("花火大会"),
                text(
                    "By: eru__chan & marzipan",
                ),
                times(
                    1.seconds.toJavaDuration(),
                    3.seconds.toJavaDuration(),
                    1.seconds.toJavaDuration(),
                ),
            ),
        )
        sleep(1.seconds)
        launch(
            anchors[0].filterIndexed { i, _ -> i % 2 == 0 },
            Effect.COMMENCE_2_CENTER,
            Height.R0,
        )
        launch(
            anchors[0].filterIndexed { i, _ -> i % 2 == 1 },
            Effect.COMMENCE_2_BURST,
            Height.R0,
        )
        launch(anchors[1], Effect.COMMENCE_2_SUB, Height.R5)
        sleep(6.seconds)
    }
}
