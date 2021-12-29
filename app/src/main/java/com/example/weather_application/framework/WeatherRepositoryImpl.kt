package com.example.weather_application.framework

import com.example.weather_application.data.WeatherRepository
import com.example.weather_application.framework.utils.handleCall
import com.example.weather_application.framework.utils.networkCall

class WeatherRepositoryImpl(
    private val service: WeatherService
) : WeatherRepository {

    override suspend fun oneCall(lat: Double, lon: Double) =
        networkCall {
            service.oneCall(lat, lon).handleCall()
        }

    override suspend fun geocode(query: String) =
        networkCall {
            service.geocode(query).handleCall()
        }

}