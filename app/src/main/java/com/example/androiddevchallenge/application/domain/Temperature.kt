package com.example.androiddevchallenge.application.domain

data class Temperature(
    val temperature: Float,
    val unit: Unit
) {
    enum class Unit {
        Celsius, Fahrenheit
    }
}