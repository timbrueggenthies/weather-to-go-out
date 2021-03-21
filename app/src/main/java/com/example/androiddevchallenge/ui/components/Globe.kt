package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.application.math.*
import com.google.gson.Gson
import java.io.InputStreamReader

@Composable
fun Globe(center: Coordinate = Coordinate(0f, 0f)) {
    val paths by rememberCoastPaths()
    WhenNotNull(value = paths) { globe ->
        val globeRadians =
            remember { globe.coasts.map { geometry -> Geometry(geometry.coordinates.map { it.toRadians() }) } }
        val offset by animateValueAsState(
            targetValue = center,
            typeConverter = Coordinate.TypeConverter,
            animationSpec = tween(durationMillis = 1000, easing = CubicBezierEasing(0f, 0.4f, 0.4f, 1f))
        )

        val positions = remember(offset) {
            val rotationMatrix = rotation(Float3(0f + offset.lat, 0f - offset.long, 180f))
            mapToGlobe(globeRadians).map {
                it
                    .map { position -> rotationMatrix * position }
                    .map { position ->
                        if (position.z < 0) position.copy(z = 0f).normalized()
                        else position
                    }
            }
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            positions.forEach { points ->
                val path = Path()
                points.forEachIndexed { index, position ->
                    val x = this.center.x - position.x * (size.width / 2)
                    val y = this.center.y + position.y * (size.height / 2)

                    if (index == 0) path.moveTo(x, y)
                    else path.lineTo(x, y)
                }
                drawPath(
                    path,
                    if (points.any { it.z < 0 }) Color.Green else Color.Red,
                    alpha = 0.5f
                )
            }
        }
    }
}

fun mapToGlobe(globeRadians: List<Geometry>): List<List<Float4>> {
    return globeRadians.map {
        val coordinates = it.coordinates
        coordinates.map { coordinate ->
            val offsetted = coordinate
            val (x, y, z) = offsetted.toGlobePosition()
            Float4(x, y, z, 0f)
        }
    }
}

@Composable
fun rememberCoastPaths(): State<Globe?> {
    val context = LocalContext.current
    return produceState(initialValue = null) {
        val file = context.resources.openRawResource(R.raw.coasts)
        val geoJson = Gson().fromJson(InputStreamReader(file), GeoJson::class.java)
        value = geoJson.toGlobe()
    }
}

class Globe(
    val coasts: List<Geometry>
)

class Geometry(
    val coordinates: List<Coordinate>
)

class GeoJson(
    val type: String,
    val features: List<GeoJsonFeature>
)

class GeoJsonFeature(
    val type: String,
    val geometry: GeoJsonGeometry
)

class GeoJsonGeometry(
    val type: String,
    val coordinates: List<List<List<Float>>>
)

fun GeoJson.toGlobe(): Globe {
    val coasts = features.map { feature ->
        val geometry = feature.geometry
        val coordinates = geometry.coordinates
        val first = coordinates.first()
        Geometry(
            first.map { Coordinate(it[1], it[0]) }
        )
    }
    return Globe(coasts)
}
