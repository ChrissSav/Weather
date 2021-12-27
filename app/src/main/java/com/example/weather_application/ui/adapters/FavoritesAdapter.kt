package com.example.weather_application.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_application.R
import com.example.weather_application.databinding.CityPlaceItemBinding
import com.example.weather_application.domain.dto.City
import com.example.weather_application.util.CityDiffCallback
import com.example.weather_application.util.setAnyText
import kotlin.math.round


class FavoritesAdapter : ListAdapter<City, FavoritesAdapter.ViewHolder>(CityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CityPlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("StringFormatMatches")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            val resources = binding.temperature.context.resources
            val currentItem = currentList[position]
            val currentWeather = currentItem.weatherInfo

            with(binding) {
                city.text = currentItem.name
                temperature.setAnyText(round(currentWeather.current.temp).toInt())
                wind.setAnyText(resources.getString(R.string.wind_placeholder, currentWeather.current.windSpeed))
                humidity.setAnyText(resources.getString(R.string.humidity_placeholder, currentWeather.current.humidity))
                icon.setImageResource(currentWeather.current.weather.icon)
            }
        }
    }

    class ViewHolder(val binding: CityPlaceItemBinding) : RecyclerView.ViewHolder(binding.root)
}

