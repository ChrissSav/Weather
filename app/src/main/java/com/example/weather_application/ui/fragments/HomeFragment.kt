package com.example.weather_application.ui.fragments

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentHomeBinding
import com.example.weather_application.domain.dto.City
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.ViewPagerAdapter
import com.example.weather_application.util.ZoomOutPageTransformer


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: MainViewModel by activityViewModels()
    private val citiesList = mutableListOf<City>()
    private lateinit var textView: TextView
    private var mLastPage = 0

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    @SuppressLint("StringFormatMatches")
    override fun setUpObservers() {

        viewModel.cities.observe(this, Observer {
            citiesList.clear()
            citiesList.addAll(it)

            (binding.viewPager.adapter as ViewPagerAdapter).submitList(citiesList)
            binding.dotsIndicator.setViewPager2(binding.viewPager)

        })

        viewModel.loader.observe(this, Observer {
            if (it) {
                binding.spinKit.visibility = View.VISIBLE
            } else {
                binding.spinKit.visibility = View.GONE
            }
        })
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun setUpViews() {


        binding.viewPager.adapter = ViewPagerAdapter()
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())

    }


}