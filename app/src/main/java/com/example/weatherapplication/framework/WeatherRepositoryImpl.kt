package com.example.weatherapplication.framework

import com.example.weatherapplication.data.WeatherRepository
import com.example.weatherapplication.framework.dto.BaseResponse
import com.example.weatherapplication.framework.utils.handleCall
import com.example.weatherapplication.framework.utils.networkCall

class WeatherRepositoryImpl(
    private val service: WeatherService
) : WeatherRepository {

    override suspend fun oneCall(lat: Double, lon: Double): BaseResponse =
        networkCall {
            service.oneCall(lat, lon).handleCall()
        }


}