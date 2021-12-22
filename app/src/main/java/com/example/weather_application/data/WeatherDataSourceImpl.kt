package com.example.weather_application.data

import com.example.weather_application.domain.WeatherDataSource
import com.example.weather_application.domain.dto.Base
import com.example.weather_application.domain.mappers.mapToBase

class WeatherDataSourceImpl(
    private val weatherRepository: WeatherRepository
) : WeatherDataSource {

    override suspend fun oneCall(lat: Double, lon: Double): Base =
        weatherRepository.oneCall(lat, lon).mapToBase()
}