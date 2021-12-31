package com.example.weather_application.domain.room.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directs")
data class DirectEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String
)
