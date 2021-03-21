package com.example.androiddevchallenge.ui.state

import com.example.androiddevchallenge.application.domain.Temperature
import com.example.androiddevchallenge.application.domain.WeatherCondition
import java.time.ZonedDateTime

data class WeatherForecast(
    val weatherCondition: WeatherCondition,
    val temperature: Temperature,
    val rainProbability: Float
)

data class HourWeatherForecast(
    val timestamp: ZonedDateTime,
    val forecast: WeatherForecast
)

data class DateWeatherForecast(
    val timestamp: ZonedDateTime,
    val forecast: WeatherForecast
)
