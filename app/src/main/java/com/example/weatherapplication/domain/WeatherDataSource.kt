package com.example.weatherapplication.domain

import com.example.weatherapplication.domain.dto.Base

interface WeatherDataSource {

    suspend fun oneCall(lat: Double, lon: Double): Base

}