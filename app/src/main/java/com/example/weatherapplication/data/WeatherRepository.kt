package com.example.weatherapplication.data

import com.example.weatherapplication.framework.dto.BaseResponse

interface WeatherRepository {

    suspend fun oneCall(lat: Double, lon: Double): BaseResponse

}