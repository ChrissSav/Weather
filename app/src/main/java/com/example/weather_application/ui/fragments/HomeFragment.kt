package com.example.weather_application.ui.fragments

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.weather_application.R
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

        /* binding.textSwitcher.setFactory {
             textView = TextView(this@HomeFragment.context)
             textView.setTextColor(Color.BLACK)
             //  textView.textSize = 60F
             textView.gravity = Gravity.CENTER_HORIZONTAL
             textView
         }*/

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.textSwitcher.setText(citiesList[position].name)
                mLastPage = position;
                super.onPageSelected(position)
            }

        })

        binding.textSwitcher.setFactory {
            textView = TextView(this@HomeFragment.context)
            textView.setTextColor(ContextCompat.getColor(this@HomeFragment.context!!, R.color.weather_item_text));
            textView.gravity = Gravity.CENTER
            textView
        }


    }


}