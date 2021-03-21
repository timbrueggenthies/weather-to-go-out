package com.example.androiddevchallenge.application.extensions

fun Float.toRadians(): Float {
    return Math.toRadians(this.toDouble()).toFloat()
}