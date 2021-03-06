package com.example.weather_application.domain.dto


data class InfoHourly(
    val dt: Long,
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val sunrise: Long,
    val sunset: Long,
    val uvi: Double,
    val windSpeed: Double,
    val weather: Weather
)
