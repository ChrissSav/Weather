package com.example.weather_application.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.weather_application.domain.dto.City
import com.example.weather_application.domain.dto.InfoDaily
import com.example.weather_application.domain.dto.InfoHourly

class InfoHourlyDiffCallback : DiffUtil.ItemCallback<InfoHourly>() {
    override fun areItemsTheSame(oldItem: InfoHourly, newItem: InfoHourly): Boolean {
        return oldItem.dt == newItem.dt
    }


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: InfoHourly, newItem: InfoHourly): Boolean {
        return oldItem == newItem
    }
}

class InfoDailyDiffCallback : DiffUtil.ItemCallback<InfoDaily>() {
    override fun areItemsTheSame(oldItem: InfoDaily, newItem: InfoDaily): Boolean {
        return oldItem.dt == newItem.dt
    }


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: InfoDaily, newItem: InfoDaily): Boolean {
        return oldItem == newItem
    }
}

class CityDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.name == newItem.name
    }


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }
}
