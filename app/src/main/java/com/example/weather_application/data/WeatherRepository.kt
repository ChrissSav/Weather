package com.example.weather_application.data

import com.example.weather_application.framework.dto.BaseResponse
import com.example.weather_application.framework.dto.DirectResponse

interface WeatherRepository {

    suspend fun oneCall(lat: Double, lon: Double): BaseResponse

    suspend fun geocode(query: String): DirectResponse
}