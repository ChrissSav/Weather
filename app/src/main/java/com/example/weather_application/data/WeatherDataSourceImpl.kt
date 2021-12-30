package com.example.weather_application.data

import com.example.weather_application.domain.WeatherDataSource
import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.domain.mappers.mapToBase
import com.example.weather_application.domain.mappers.mapToDirect

class WeatherDataSourceImpl(
    private val weatherRepository: WeatherRepository
) : WeatherDataSource {

    override suspend fun oneCall(lat: Double, lon: Double) =
        weatherRepository.oneCall(lat, lon).mapToBase()

    override suspend fun geocode(query: String): MutableList<Direct> =
        weatherRepository.geocode(query)
            .map { it.mapToDirect() }
            .filter { it.name != "null" }
            .toMutableList()
}