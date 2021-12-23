package com.example.weather_application.domain.dto


data class City(
    val details: Direct,
    val weatherInfo: Base
) {
    val name
        get() = "${details.name} (${details.country})"
}
