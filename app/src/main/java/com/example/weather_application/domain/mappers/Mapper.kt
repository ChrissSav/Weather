package com.example.weather_application.domain.mappers

import com.example.weather_application.R
import com.example.weather_application.domain.dto.*
import com.example.weather_application.framework.dto.*
import com.example.weather_application.util.convertCurrentTimestampToFormat
import com.example.weather_application.util.convertTimestampToFormat

fun InfoResponseDaily.mapToInfoDaily(): InfoDaily =
    InfoDaily(dt, temp.mapToTemp(), pressure, humidity, uvi, windSpeed, weather[0].mapWeather())

fun InfoResponseHourly.mapToInfoHourly(): InfoHourly =
    InfoHourly(
        dt, temp, pressure, humidity, sunrise,
        sunset, uvi, windSpeed, weather[0].mapWeather()
    )

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

fun WeatherInfoResponse.mapWeather(): Weather {
    val iconCode = when (id) {
        in 200..299 -> R.drawable.ic_thunderstorm
        in 300..399 -> R.drawable.ic_rain
        in 500..599 -> R.drawable.ic_rain
        in 600..699 -> R.drawable.ic_snow
        in 700..799 -> R.drawable.ic_mist
        800 -> R.drawable.ic_sun
        else -> R.drawable.ic_few_clouds

    }

    return Weather(main, description, iconCode)
}


fun TempResponse.mapToTemp(): Temp =
    Temp(day, min, max, night, eve, morn)
