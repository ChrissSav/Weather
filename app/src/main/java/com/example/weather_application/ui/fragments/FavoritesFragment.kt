package com.example.weather_application.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentFavoritesBinding
import com.example.weather_application.ui.MainViewModel
import com.example.weather_application.ui.adapters.FavoritesAdapter


class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    private val viewModel: MainViewModel by activityViewModels()


    override fun getViewBinding(): FragmentFavoritesBinding =
        FragmentFavoritesBinding.inflate(layoutInflater)

    override fun setUpObservers() {

        viewModel.cities.observe(this, Observer {

            (binding.recyclerView.adapter as FavoritesAdapter).submitList(it)

        })
    }

    override fun setUpViews() {

        binding.recyclerView.adapter = FavoritesAdapter()

    }
}