package com.example.weather_application.domain.mappers

import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.domain.room.entites.DirectEntity


fun DirectEntity.mapToDirect() = Direct(name, lat, lon, country)


fun Direct.mapToDirectEntity() = DirectEntity(name + country, name, lat, lon, country)
