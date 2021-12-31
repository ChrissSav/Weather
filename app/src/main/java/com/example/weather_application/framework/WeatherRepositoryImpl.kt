package com.example.weather_application.framework

import com.example.weather_application.data.WeatherRepository
import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.domain.mappers.mapToDirectEntity
import com.example.weather_application.domain.room.dao.DirectDao
import com.example.weather_application.domain.room.entites.DirectEntity
import com.example.weather_application.framework.utils.handleCall
import com.example.weather_application.framework.utils.networkCall
import com.example.weather_application.framework.utils.roomCall

class WeatherRepositoryImpl(
    private val service: WeatherService,
    private val directDao: DirectDao
) : WeatherRepository {

    override suspend fun oneCall(lat: Double, lon: Double) =
        networkCall {
            service.oneCall(lat, lon).handleCall()
        }

    override suspend fun geocode(query: String) =
        networkCall {
            service.geocode(query).handleCall()
        }

    override suspend fun saveLocalDirect(direct: Direct) =
        roomCall {
            directDao.insertDirect(direct.mapToDirectEntity())
            direct.mapToDirectEntity()
        }

    override suspend fun getLocalDirects() =
        roomCall {
            directDao.getDirects()
        }

    override suspend fun deleteLocalDirect(directEntity: DirectEntity) =
        roomCall {
            directDao.delete(directEntity)
        }


}