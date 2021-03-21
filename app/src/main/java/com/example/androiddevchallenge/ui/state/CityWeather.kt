package com.example.androiddevchallenge.ui.state

import com.example.androiddevchallenge.application.domain.City
import com.example.androiddevchallenge.application.domain.Temperature
import com.example.androiddevchallenge.application.domain.WeatherCondition
import com.example.androiddevchallenge.application.domain.Wind

data class CityWeather(
    val city: City,
    val currentTemperature: Temperature,
    val currentCondition: WeatherCondition,
    val wind: Wind,
    val humidity: Float,
    val hourlyForecast: List<HourWeatherForecast>,
    val weekForecast: List<DateWeatherForecast>
)