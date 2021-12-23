package com.example.weather_application.domain

import com.example.weather_application.domain.dto.Base
import com.example.weather_application.domain.dto.Direct

interface WeatherDataSource {

    suspend fun oneCall(lat: Double, lon: Double): Base

    suspend fun geocode(query: String): Direct
}