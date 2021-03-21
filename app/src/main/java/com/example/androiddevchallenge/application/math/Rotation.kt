package com.example.androiddevchallenge.application.math

import kotlin.math.pow
import kotlin.math.sqrt

fun Float4.normalized(): Float4 {
    val magnitude = sqrt(x.pow(2) + y.pow(2) + z.pow(2))
    return Float4(
        x / magnitude,
        y / magnitude,
        z / magnitude,
        0f
    )
}