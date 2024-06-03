package com.baakun.feux.scripts

import kotlin.time.Duration

interface Script {
    fun run()

    fun sleep(duration: Duration) {
        Thread.sleep(duration.inWholeMilliseconds)
    }
}
