package com.example.weatherapplication.data

import com.example.weatherapplication.domain.WeatherDataSource
import com.example.weatherapplication.domain.dto.Base
import com.example.weatherapplication.domain.mappers.mapToBase

class WeatherDataSourceImpl(
    private val weatherRepository: WeatherRepository
) : WeatherDataSource {

    override suspend fun oneCall(lat: Double, lon: Double): Base =
        weatherRepository.oneCall(lat, lon).mapToBase()
}