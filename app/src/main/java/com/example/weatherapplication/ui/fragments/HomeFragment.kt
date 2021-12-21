package com.example.weatherapplication.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weatherapplication.data.base.BaseFragment
import com.example.weatherapplication.databinding.FragmentHomeBinding
import com.example.weatherapplication.ui.MainViewModel
import com.example.weatherapplication.ui.adapters.DailyAdapter
import com.example.weatherapplication.ui.adapters.HoursAdapter
import com.example.weatherapplication.util.setAnyText


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUpObservers() {

        viewModel.weather.observe(this, Observer {
            with(binding) {
                //   temperature.setAnyText(kotlin.math.ceil(it.current.temp).roundToInt())
                temperature.setAnyText(it.current.temp)
                weather.setAnyText(it.current.weather.description)
                humidity.setAnyText(it.current.humidity)
                wind.setAnyText(it.current.windSpeed)

                (binding.recyclerViewHour.adapter as HoursAdapter).submitList(it.hourly)
                (binding.recyclerViewDay.adapter as DailyAdapter).submitList(it.daily)
            }
        })
    }

    override fun setUpViews() {

        binding.recyclerViewHour.adapter = HoursAdapter()
        binding.recyclerViewDay.adapter = DailyAdapter()

        viewModel.loadWeather(40.6403167, 22.9352716)
    }
}