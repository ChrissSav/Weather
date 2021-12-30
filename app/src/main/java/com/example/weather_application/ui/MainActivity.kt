package com.example.weather_application.ui

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.weather_application.R
import com.example.weather_application.data.base.BaseActivityViewModel
import com.example.weather_application.databinding.ActivityMainBinding
import com.example.weather_application.util.createAlerter
import com.example.weather_application.util.navigateToDestination
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivityViewModel<ActivityMainBinding, MainViewModel>(MainViewModel::class.java) {

    private lateinit var navController: NavController

    override fun provideViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun setUpObservers() {
        viewModel.error.observe(this, {
            if (it.internal)
                createAlerter(getString(it.messageId))
            else
                createAlerter(it.message)
        })

    }

    override fun setUpViews() {

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->


            if (destination.id != R.id.homeFragment) {
                binding.imageButtonSettings.visibility = View.GONE
                binding.imageButtonFavorites.visibility = View.GONE
            } else {
                binding.imageButtonSettings.visibility = View.VISIBLE
                binding.imageButtonFavorites.visibility = View.VISIBLE
            }


        }


        binding.imageButtonFavorites.setOnClickListener {
            navController.navigateToDestination(R.id.favoritesFragment)
        }

        binding.imageButtonSettings.setOnClickListener {
            navController.navigateToDestination(R.id.settingsFragment)
        }
        // viewModel.loadWeather("θεσσαλονικη", "larisa", "berlin")
        viewModel.loadWeather()

    }

}