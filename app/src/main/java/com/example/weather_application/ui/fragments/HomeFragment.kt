package com.example.weather_application.ui.fragments

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentHomeBinding
import com.example.weather_application.domain.dto.City
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.ViewPagerAdapter
import com.example.weather_application.util.ZoomOutPageTransformer
import com.example.weather_application.util.clearAndAddAll
import com.example.weather_application.util.visibleOrGone


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: MainViewModel by activityViewModels()
    private val citiesList = mutableListOf<City>()

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun setUpObservers() {

        viewModel.cities.observe(this, Observer {
            citiesList.clearAndAddAll(it)

            (binding.viewPager.adapter as ViewPagerAdapter).submitList(citiesList)
            binding.dotsIndicator.setViewPager2(binding.viewPager)

            binding.dotsIndicator.visibleOrGone(citiesList.isNotEmpty())
            binding.notFoundContainer.visibleOrGone(citiesList.isEmpty())
        })

        viewModel.loader.observe(this, Observer {
            if (it) {
                binding.dotsIndicator.visibility = View.GONE
                binding.spinKit.visibility = View.VISIBLE
            } else {
                binding.spinKit.visibility = View.GONE
            }
        })
    }

    override fun setUpViews() {
        binding.viewPager.adapter = ViewPagerAdapter()
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
    }

}