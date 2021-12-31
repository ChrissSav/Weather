package com.example.weather_application.data

import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.domain.room.entites.DirectEntity
import com.example.weather_application.framework.dto.BaseResponse
import com.example.weather_application.framework.dto.DirectResponse

interface WeatherRepository {

    suspend fun oneCall(lat: Double, lon: Double): BaseResponse

    suspend fun geocode(query: String): MutableList<DirectResponse>

    suspend fun saveLocalDirect(direct: Direct): DirectEntity

    suspend fun getLocalDirects(): MutableList<DirectEntity>

    suspend fun deleteLocalDirect(directEntity: DirectEntity)

}