package com.example.weather_application.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weather_application.data.base.BaseViewModel
import com.example.weather_application.data.base.SingleLiveEvent
import com.example.weather_application.domain.WeatherDataSource
import com.example.weather_application.domain.dto.City
import com.example.weather_application.domain.dto.Direct
import com.example.weather_application.framework.utils.addItem

class MainViewModel
@ViewModelInject
constructor(
    private val weatherDataSource: WeatherDataSource
) : BaseViewModel() {


    private val _cities = MutableLiveData<MutableList<City>>()
    val cities: LiveData<MutableList<City>> = _cities

    private val _directions = SingleLiveEvent<MutableList<Direct>>()
    val directions: LiveData<MutableList<Direct>> = _directions

    val loader = SingleLiveEvent<Boolean>()

    fun loadWeather() {
        launch(loader) {
            val directs = weatherDataSource.getLocalDirects()
            val temp = mutableListOf<City>()
            for (direct in directs) {
                val weather = weatherDataSource.oneCall(direct.lat, direct.lon)
                temp.add(City(direct, weather))
            }
            _cities.value = temp
        }
    }


    fun addDirect(direct: Direct) {
        launch(loader) {
            val directT = weatherDataSource.saveLocalDirect(direct)
            val weather = weatherDataSource.oneCall(directT.lat, directT.lon)
            _cities.addItem((City(direct, weather)))
        }
    }


    fun deleteCity(city: City) {
        launch {
            weatherDataSource.deleteLocalDirect(city.details)
            val temp = _cities.value ?: mutableListOf()
            _cities.value = temp.filter { it.fullName != city.fullName }.toMutableList()
        }
    }

    fun loadDirections(query: String) {
        launch {
            _directions.value = weatherDataSource.geocode(query)
        }
    }

}