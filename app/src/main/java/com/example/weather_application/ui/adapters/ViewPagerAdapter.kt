package com.example.weather_application.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_application.R
import com.example.weather_application.databinding.ItemListBinding
import com.example.weather_application.domain.dto.City
import com.example.weather_application.util.CityDiffCallback
import com.example.weather_application.util.convertTimestampToFormat
import com.example.weather_application.util.firstLetterUpperCase
import com.example.weather_application.util.setAnyText
import kotlin.math.round

const val HPA = 0.000986923266716F

class ViewPagerAdapter : ListAdapter<City, ViewPagerAdapter.ViewHolder>(CityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("StringFormatMatches")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        with(holder) {


            val listener = object : RecyclerView.OnItemTouchListener {
                override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                    val action = e.action
                    return if (binding.recyclerViewHour.canScrollHorizontally(RecyclerView.FOCUS_FORWARD)) {
                        when (action) {
                            MotionEvent.ACTION_MOVE -> rv.parent
                                .requestDisallowInterceptTouchEvent(true)
                        }
                        false
                    } else {
                        when (action) {
                            android.view.MotionEvent.ACTION_MOVE -> rv.parent
                                .requestDisallowInterceptTouchEvent(false)
                        }
                        binding.recyclerViewHour.removeOnItemTouchListener(this)
                        true
                    }
                }

                override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}
                override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
            }

            binding.recyclerViewHour.addOnItemTouchListener(listener)


            val resources = binding.temperature.context.resources
            val currentItem = currentList[position]
            val currentWeather = currentItem.weatherInfo

            with(binding) {

                title.text = currentItem.fullName
                temperature.setAnyText(round(currentWeather.current.temp).toInt())
                weather.setAnyText(currentWeather.current.weather.description.firstLetterUpperCase())
                wind.setAnyText(resources.getString(R.string.wind_placeholder, currentWeather.current.windSpeed))
                pressure.setAnyText(resources.getString(R.string.pressure_placeholder, round(currentWeather.current.pressure * HPA)))
                humidity.setAnyText(resources.getString(R.string.humidity_placeholder, currentWeather.current.humidity))

                icon.setImageResource(currentWeather.current.weather.icon)

                sunrise.setAnyText(convertTimestampToFormat(currentWeather.current.sunrise, "HH:mm"))
                sunset.setAnyText(convertTimestampToFormat(currentWeather.current.sunset, "HH:mm"))

                recyclerViewHour.adapter = HoursAdapter()
                recyclerViewDay.adapter = DailyAdapter()
                (recyclerViewHour.adapter as HoursAdapter).submitList(currentWeather.hourly)
                (recyclerViewDay.adapter as DailyAdapter).submitList(currentWeather.daily)


            }

        }
    }

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
}

