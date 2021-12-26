package com.example.weather_application.ui.fragments

import android.annotation.SuppressLint
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.R
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentSettingsBinding
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.HPA
import com.example.weather_application.util.firstLetterUpperCase
import com.example.weather_application.util.setAnyText
import kotlin.math.round


class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    private val viewModel: MainViewModel by activityViewModels()


    override fun getViewBinding(): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater)

    @SuppressLint("StringFormatMatches")
    override fun setUpObservers() {
        viewModel.cities.observe(this, Observer {

            val currentItem = it.first()
            val currentWeather = currentItem.weatherInfo


            with(binding) {

                title.text = currentItem.name
                temperature.setAnyText(round(currentWeather.current.temp).toInt())
                weather.setAnyText(currentWeather.current.weather.description.firstLetterUpperCase())
                wind.setAnyText(resources.getString(R.string.wind_placeholder, currentWeather.current.windSpeed))
                pressure.setAnyText(resources.getString(R.string.pressure_placeholder, round(currentWeather.current.pressure * HPA)))
                humidity.setAnyText(resources.getString(R.string.humidity_placeholder, currentWeather.current.humidity))
                icon.setImageResource(currentWeather.current.weather.icon)
            }

        })
    }

    override fun setUpViews() {
    }
}