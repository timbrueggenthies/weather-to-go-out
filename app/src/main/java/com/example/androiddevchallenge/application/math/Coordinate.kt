package com.example.androiddevchallenge.application.math

import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import com.example.androiddevchallenge.application.extensions.toRadians
import kotlin.math.cos
import kotlin.math.sin

data class Coordinate(
    val lat: Float,
    val long: Float
) {

    fun toRadians(): Coordinate {
        return Coordinate(
            lat.toRadians(),
            long.toRadians()
        )
    }

    operator fun minus(other: Coordinate): Coordinate {
        return Coordinate(lat - other.lat, long - other.long)
    }

    operator fun plus(other: Coordinate): Coordinate {
        return Coordinate(lat + other.lat, long + other.long)
    }

    companion object {

        val TypeConverter: TwoWayConverter<Coordinate, AnimationVector2D> =
            TwoWayConverter(
                convertToVector = { AnimationVector2D(it.lat, it.long) },
                convertFromVector = { Coordinate(it.v1, it.v2) }
            )
    }
}

fun Coordinate.toGlobePosition(): Float3 {
    val y = sin(lat)
    val x = sin(long) * cos(lat)
    val z = cos(long) * cos(lat)

    return Float3(x, y, z)
}