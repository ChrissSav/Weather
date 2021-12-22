package com.example.weather_application.framework.dto

import com.google.gson.annotations.SerializedName

data class InfoResponseDaily(
    val dt: Long,
    val temp: TempResponse,
    val pressure: Int,
    val humidity: Int,
    @SerializedName("dew_point")
    val dewPoint: Double,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    @SerializedName("wind_speed")
    val windSpeed: Double,
    @SerializedName("wind_deg")
    val windDeg: Int,
    @SerializedName("wind_gust")
    val windGust: Double,
    val weather: MutableList<WeatherInfoResponse>
)
