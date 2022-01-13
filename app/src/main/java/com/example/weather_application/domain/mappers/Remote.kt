package com.example.weather_application.domain.mappers

import com.example.weather_application.R
import com.example.weather_application.domain.dto.*
import com.example.weather_application.framework.dto.*
import com.example.weather_application.util.getAppLanguage

fun InfoResponseDaily.mapToInfoDaily(): InfoDaily =
    InfoDaily(dt, temp.mapToTemp(), pressure, humidity, uvi, windSpeed, weather[0].mapWeather())

fun InfoResponseHourly.mapToInfoHourly(): InfoHourly =
    InfoHourly(
        dt, temp, pressure, humidity, sunrise,
        sunset, uvi, windSpeed, weather[0].mapWeather()
    )

fun BaseResponse.mapToBase(): Base =
    Base(
        lat, lon, current.mapToInfoHourly(),
        hourly.map { it.mapToInfoHourly() }.toMutableList().subList(1, hourly.size),
        daily.map { it.mapToInfoDaily() }.toMutableList()
    )


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


fun TempResponse.mapToTemp(): Temperature = Temperature(day, min, max, night, eve, morn)


fun DirectResponse.mapToDirect(): Direct? {
    var loName: String? = this.name

    this.localNames?.let {
        loName = it[getAppLanguage()] ?: it["en"]
    }

    if (loName == null)
        return null;

    return Direct(loName.toString(), lat, lon, country)
}
