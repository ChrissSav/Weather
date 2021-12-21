package com.example.weatherapplication.domain.dto


data class InfoDaily(
    val dt: Long,
    val temp: Temp,
    val pressure: Int,
    val humidity: Int,
    val uvi: Double,
    val windSpeed: Double,
    val weather: Weather
)
