package com.example.weather_application.ui.fragments

import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentHomeBinding


class FavoritesFragment : BaseFragment<FragmentHomeBinding>() {


    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUpObservers() {
    }

    override fun setUpViews() {
    }
}