package com.example.weather_application.framework.dto

import com.google.gson.annotations.SerializedName

data class DirectResponse(
    @SerializedName("local_names")
    val localNames: HashMap<String, String>?,
    val name: String,
    val lat: Double,
    val lon: Double,
    val country: String
)
