package com.example.weather_application.ui.fragments

import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentFavoritesBinding


class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {


    override fun getViewBinding(): FragmentFavoritesBinding =
        FragmentFavoritesBinding.inflate(layoutInflater)

    override fun setUpObservers() {
    }

    override fun setUpViews() {
    }
}