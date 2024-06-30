package com.baakun.feux.util

fun <T> List<T>.evens() = this.filterIndexed { index, _ -> index % 2 == 0 }

fun <T> List<T>.odds() = this.filterIndexed { index, _ -> index % 2 == 1 }

fun <T> List<T>.leftToCenter() = this.subList(0, this.size / 2)

fun <T> List<T>.rightToCenter() = this.subList(this.size / 2, this.size).reversed()

fun <T> List<T>.center(): T = this[this.size / 2]
