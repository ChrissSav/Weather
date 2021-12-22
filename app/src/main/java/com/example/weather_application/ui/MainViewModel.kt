package com.example.weather_application.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.example.weather_application.data.base.BaseViewModel
import com.example.weather_application.data.base.SingleLiveEvent
import com.example.weather_application.domain.WeatherDataSource
import com.example.weather_application.domain.dto.Base

class MainViewModel
@ViewModelInject
constructor(
    private val weatherDataSource: WeatherDataSource
) : BaseViewModel() {


    private val _weather = SingleLiveEvent<Base>()
    val weather: LiveData<Base> = _weather


    fun loadWeather(lat: Double, lot: Double) {
        launch {
            _weather.value = weatherDataSource.oneCall(lat, lot)
        }
    }

}