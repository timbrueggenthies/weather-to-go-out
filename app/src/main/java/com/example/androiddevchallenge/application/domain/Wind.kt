package com.example.androiddevchallenge.application.domain

data class Wind(
    val speed: Float,
    val unit: Unit,
    val direction: Direction
) {
    enum class Unit {
        MilesPerHour, KilometersPerHour
    }
}