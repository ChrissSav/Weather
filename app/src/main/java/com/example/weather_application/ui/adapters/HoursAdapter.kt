package com.example.weather_application.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_application.databinding.WeatherHourlyItemBinding
import com.example.weather_application.domain.dto.InfoHourly
import com.example.weather_application.util.InfoHourlyDiffCallback
import com.example.weather_application.util.convertTimestampToFormat
import com.example.weather_application.util.setAnyText
import kotlin.math.round


class HoursAdapter : ListAdapter<InfoHourly, HoursAdapter.ViewHolder>(InfoHourlyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeatherHourlyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {

            val currentItem = currentList[position]

            if (position == 0) {
                binding.hour.text = convertTimestampToFormat(currentItem.dt, "HH:mm")
            } else {
                val previous = currentList[position - 1]
                if (convertTimestampToFormat(currentItem.dt, "MMM d") != convertTimestampToFormat(previous.dt, "MMM d")) {
                    binding.hour.text = convertTimestampToFormat(currentItem.dt, "dd MMM ")
                } else {
                    binding.hour.text = convertTimestampToFormat(currentItem.dt, "HH:mm")
                }
            }

            binding.temperature.setAnyText(round(currentItem.temp).toInt())
            binding.icon.setImageResource(currentItem.weather.icon)

        }
    }

    class ViewHolder(val binding: WeatherHourlyItemBinding) : RecyclerView.ViewHolder(binding.root)
}

