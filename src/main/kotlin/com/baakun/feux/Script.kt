package com.baakun.feux

import kotlin.time.Duration


abstract class Script(vararg acts: Act) {
    private val acts: List<Act> = acts.toList()

    interface Act {
        fun start()

        fun sleep(duration: Duration) = Thread.sleep(duration.inWholeMilliseconds)
    }

    fun start() {
        acts.forEach {
            it.start()
        }
    }
}
