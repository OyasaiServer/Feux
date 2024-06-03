package com.baakun.feux

import com.baakun.feux.Feux.Companion.feux

object Config {
    val horizontalInterval = feux.config.getInt("horizontal_interval")
    val horizontalOffset = feux.config.getInt("horizontal_offset")
    val verticalInterval = feux.config.getInt("vertical_interval")
    val wings = feux.config.getInt("wings")
    val rows = feux.config.getInt("rows")
}
