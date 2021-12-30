package com.example.weather_application.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_application.R
import com.example.weather_application.databinding.CityPlaceItemBinding
import com.example.weather_application.domain.dto.City
import com.example.weather_application.util.CityPairDiffCallback
import com.example.weather_application.util.setAnyText
import kotlin.math.round


class FavoritesAdapter(
    private val onItemDeleteListener: (City) -> Unit
) : ListAdapter<Pair<City, Boolean>, FavoritesAdapter.ViewHolder>(CityPairDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CityPlaceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("StringFormatMatches")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            val resources = binding.temperature.context.resources
            val currentItem = currentList[position].first
            val currentWeather = currentItem.weatherInfo

            with(binding) {
                city.text = currentItem.details.name
                country.text = currentItem.details.country
                temperature.setAnyText(round(currentWeather.current.temp).toInt())
                wind.setAnyText(resources.getString(R.string.wind_placeholder, currentWeather.current.windSpeed))
                humidity.setAnyText(resources.getString(R.string.humidity_placeholder, currentWeather.current.humidity))
                icon.setImageResource(currentWeather.current.weather.icon)

                delete.visibility = if (currentList[position].second) View.VISIBLE else View.GONE

                delete.setOnClickListener {
                    onItemDeleteListener.invoke(currentItem)
                }
            }
        }
    }

    class ViewHolder(val binding: CityPlaceItemBinding) : RecyclerView.ViewHolder(binding.root)
}

