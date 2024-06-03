package com.baakun.feux

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Logger {
    val logger: Logger
        get() = LoggerFactory.getLogger(this::class.java)
}
