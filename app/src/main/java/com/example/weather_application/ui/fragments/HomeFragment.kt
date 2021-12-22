package com.example.weather_application.ui.fragments

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.R
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentHomeBinding
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.DailyAdapter
import com.example.weather_application.ui.adapters.HoursAdapter
import com.example.weather_application.util.convertTimestampToFormat
import com.example.weather_application.util.firstLetterUpperCase
import com.example.weather_application.util.setAnyText
import kotlin.math.round


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    @SuppressLint("StringFormatMatches")
    override fun setUpObservers() {

        viewModel.weather.observe(this, Observer {
            with(binding) {


                temperature.setAnyText(round(it.current.temp).toInt())
                weather.setAnyText(it.current.weather.description.firstLetterUpperCase())
                wind.setAnyText(getString(R.string.wind_placeholder, it.current.windSpeed))
                pressure.setAnyText(getString(R.string.pressure_placeholder, it.current.pressure / 1000))
                humidity.setAnyText(getString(R.string.humidity_placeholder, it.current.humidity))

                icon.setImageResource(it.current.weather.icon)

                sunrise.setAnyText(convertTimestampToFormat(it.current.sunrise, "HH:mm"))
                sunset.setAnyText(convertTimestampToFormat(it.current.sunset, "HH:mm"))

                (recyclerViewHour.adapter as HoursAdapter).submitList(it.hourly)
                (recyclerViewDay.adapter as DailyAdapter).submitList(it.daily)

                scrollView.visibility = View.VISIBLE


            }
        })

        viewModel.loader.observe(this, Observer {
            if (it) {
                binding.spinKit.visibility = View.VISIBLE
            } else {
                binding.spinKit.visibility = View.GONE
            }
        })
    }

    override fun setUpViews() {

        binding.recyclerViewHour.adapter = HoursAdapter()
        binding.recyclerViewDay.adapter = DailyAdapter()

        viewModel.loadWeather(40.6403167, 22.9352716)
    }
}