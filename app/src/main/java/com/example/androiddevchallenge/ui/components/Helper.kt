package com.example.androiddevchallenge.ui.components

import androidx.compose.runtime.Composable

@Composable
fun <T> WhenNotNull(value: T?, content: @Composable (T) -> Unit) {
    if (value != null) content(value)
}