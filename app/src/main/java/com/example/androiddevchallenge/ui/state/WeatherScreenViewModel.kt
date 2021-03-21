package com.example.androiddevchallenge.ui.state

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.application.domain.*
import com.example.androiddevchallenge.application.math.Coordinate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherScreenViewModel: ViewModel() {

    val weather: Flow<CityWeather> = flow {
        emit(CITY_WEATHER)
    }

    companion object {
        private val CITY_WEATHER = CityWeather(
            city = City("San Francisco", Coordinate(37.773972f, -122.431297f)),
            currentTemperature = Temperature(18f, Temperature.Unit.Celsius),
            currentCondition = WeatherCondition.Sunny,
            wind = Wind(12f, Wind.Unit.KilometersPerHour, Direction.North),
            humidity = 0.2f,
            hourlyForecast = emptyList(),
            weekForecast = emptyList()
        )
    }
}