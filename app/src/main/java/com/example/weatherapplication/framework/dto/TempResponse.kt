package com.example.weatherapplication.framework.dto

data class TempResponse(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)
