package com.example.weather_application.domain.dto

data class Direct(
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String
) {
    val fullName
        get() = "$name ($country)"
}
