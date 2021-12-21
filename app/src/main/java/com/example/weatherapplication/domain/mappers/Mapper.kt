package com.example.weatherapplication.domain.mappers

import com.example.weatherapplication.domain.dto.*
import com.example.weatherapplication.framework.dto.*
import com.example.weatherapplication.util.convertCurrentTimestampToFormat
import com.example.weatherapplication.util.convertTimestampToFormat

fun InfoResponseDaily.mapToInfoDaily(): InfoDaily =
    InfoDaily(dt, temp.mapToTemp(), pressure, humidity, uvi, windSpeed, weather[0].mapWeather())

fun InfoResponseHourly.mapToInfoHourly(): InfoHourly =
    InfoHourly(dt, temp, pressure, humidity, uvi, windSpeed, weather[0].mapWeather())

fun BaseResponse.mapToBase(): Base {

    val currentDay = convertCurrentTimestampToFormat("EEEE")

    val hoursTempList = hourly
        .filter { convertTimestampToFormat(it.dt, "EEEE") == currentDay }
        .map { it.mapToInfoHourly() }.toMutableList()

    return Base(
        lat, lon, current.mapToInfoHourly(),
        hoursTempList,
        daily.map { it.mapToInfoDaily() }.toMutableList()
    )

}

fun WeatherInfoResponse.mapWeather(): Weather =
    Weather(main, description)


fun TempResponse.mapToTemp(): Temp =
    Temp(day, min, max, night, eve, morn)
