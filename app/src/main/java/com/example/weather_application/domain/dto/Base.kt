package com.example.weather_application.domain.dto

data class Base(
    val lat: Double,
    val lon: Double,
    val current: InfoHourly,
    val hourly: MutableList<InfoHourly>,
    val daily: MutableList<InfoDaily>
)
