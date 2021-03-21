package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.application.domain.WeatherCondition
import com.example.androiddevchallenge.ui.theme.LocalWeatherColors

@Composable
fun WeatherConditionBadge(weatherCondition: WeatherCondition) {
    Text(text = weatherCondition.name, modifier = Modifier
        .clip(CircleShape)
        .background(LocalWeatherColors.current.badgeColor)
        .padding(16.dp, 8.dp))
}