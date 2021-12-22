package com.example.weather_application.data

import com.example.weather_application.framework.dto.BaseResponse

interface WeatherRepository {

    suspend fun oneCall(lat: Double, lon: Double): BaseResponse

}