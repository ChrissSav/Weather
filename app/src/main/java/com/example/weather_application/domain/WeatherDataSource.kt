package com.example.weather_application.domain

import com.example.weather_application.domain.dto.Base

interface WeatherDataSource {

    suspend fun oneCall(lat: Double, lon: Double): Base

}