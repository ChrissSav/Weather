package com.example.weatherapplication.domain.dto


data class InfoHourly(
    val dt: Long,
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val uvi: Double,
    val windSpeed: Double,
    val weather: Weather
)
