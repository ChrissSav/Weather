package com.example.weatherapplication.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapplication.domain.dto.InfoDaily
import com.example.weatherapplication.domain.dto.InfoHourly

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