package com.example.weather_application.domain.dto

data class Weather(
    val main: String,
    val description: String,
    val icon: Int
)
