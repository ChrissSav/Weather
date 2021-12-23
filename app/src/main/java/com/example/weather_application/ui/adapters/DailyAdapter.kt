package com.example.weather_application.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_application.databinding.WeatherDailyItemBinding
import com.example.weather_application.domain.dto.InfoDaily
import com.example.weather_application.util.InfoDailyDiffCallback
import com.example.weather_application.util.convertTimestampToFormat
import com.example.weather_application.util.setAnyText
import kotlin.math.round


class DailyAdapter : ListAdapter<InfoDaily, DailyAdapter.ViewHolder>(InfoDailyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeatherDailyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {

            val currentItem = currentList[position]

            binding.day.text = convertTimestampToFormat(currentItem.dt, "EEEE")
            binding.temperatureMax.setAnyText(round(currentItem.temperature.max).toInt())
            binding.temperature.setAnyText(round(currentItem.temperature.min).toInt())
            binding.icon.setImageResource(currentItem.weather.icon)

        }
    }

    class ViewHolder(val binding: WeatherDailyItemBinding) : RecyclerView.ViewHolder(binding.root)
}

