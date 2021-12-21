package com.example.weatherapplication.framework.dto


data class BaseResponse(
    val lat: Double,
    val lon: Double,
    val current: InfoResponseHourly,
    val hourly: MutableList<InfoResponseHourly>,
    val daily: MutableList<InfoResponseDaily>
)
