package com.abulnes16.tempo_native.models

data class Weather(
    val weatherType: String,
    val temperature: String,
    val city: String,
    val country: String,
    val humidity: String,
    val wind: String
)

