/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/* Colors of Weather App */

class WeatherColors(
    val badgeColor: Color
)

private val badgeColorDark = Color(56, 53, 84)
private val badgeColorLight = Color(56, 53, 84)

val LocalWeatherColors = staticCompositionLocalOf { LightWeatherColors }

val LightWeatherColors = WeatherColors(
    badgeColor = badgeColorLight
)

val DarkWeatherColors = WeatherColors(
    badgeColor = badgeColorDark
)

/* Base Material Colors */

private val primaryColor = Color(0xFFBB86FC)
private val secondaryColor = Color(0xFF03DAC5)
private val backgroundDark = Color(29, 33, 46)

val DarkColorPalette = darkColors(
    background = backgroundDark
)

val LightColorPalette = lightColors()

