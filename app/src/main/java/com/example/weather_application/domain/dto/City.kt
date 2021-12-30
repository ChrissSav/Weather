package com.example.weather_application.domain.dto


data class City(
    val details: Direct,
    val weatherInfo: Base
) {
    val fullName
        get() = "${details.name} (${details.country})"
}
