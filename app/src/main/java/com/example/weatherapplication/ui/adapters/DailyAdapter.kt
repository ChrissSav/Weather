package com.example.weatherapplication.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.databinding.WeatherDailyItemBinding
import com.example.weatherapplication.domain.dto.InfoDaily
import com.example.weatherapplication.util.InfoDailyDiffCallback
import com.example.weatherapplication.util.convertTimestampToFormat
import com.example.weatherapplication.util.setAnyText
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
            binding.temperatureMax.setAnyText(round(currentItem.temp.max).toInt())
            binding.temperature.setAnyText(round(currentItem.temp.min).toInt())
            binding.icon.setImageResource(currentItem.weather.icon)

        }
    }

    class ViewHolder(val binding: WeatherDailyItemBinding) : RecyclerView.ViewHolder(binding.root)
}

