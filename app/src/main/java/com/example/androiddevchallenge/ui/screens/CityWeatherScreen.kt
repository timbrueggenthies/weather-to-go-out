package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.application.domain.WeatherCondition
import com.example.androiddevchallenge.ui.components.Globe
import com.example.androiddevchallenge.ui.components.WeatherConditionBadge
import com.example.androiddevchallenge.ui.state.CityWeather
import com.example.androiddevchallenge.ui.state.WeatherScreenViewModel
import com.example.androiddevchallenge.ui.theme.LocalWeatherColors
import com.example.androiddevchallenge.ui.theme.firaSansFontFamily
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import kotlin.run

@Composable
fun CityWeatherScreen(viewModel: WeatherScreenViewModel = viewModel()) {
    val weatherState by viewModel.weather.collectAsState(initial = null)
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        weatherState?.let {
            CityWeatherContent(it)
        } ?: run {
            WeatherLoadingSpinner()
        }
    }
}

@Composable
fun CityWeatherContent(weatherState: CityWeather) {
    Column(Modifier.fillMaxSize()) {
        CityWeatherHeader(weatherState)
    }
}

@Composable
fun CityWeatherHeader(weatherState: CityWeather) {
    Column {
        Row {
            Column(
                Modifier
                    .padding(24.dp)
                    .fillMaxWidth(1 / 3f)
                    .statusBarsPadding()
                    .navigationBarsPadding()
            ) {
                Text(text = weatherState.city.name, style = MaterialTheme.typography.h3)
                Text(text = "${weatherState.currentTemperature.temperature}°", fontFamily = firaSansFontFamily, fontSize = 52.sp)
                WeatherConditionBadge(weatherState.currentCondition)
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .scale(1.2f)
                    .offset(64.dp)
            ) {
                Globe(weatherState.city.location)
            }
        }
    }
}



@Composable
fun WeatherLoadingSpinner() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Loading...")
    }
}