package com.example.weatherapplication.ui

import androidx.navigation.NavController
import com.example.weatherapplication.data.base.BaseActivityViewModel
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.util.createAlerter
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

    //    navController = findNavController(R.id.nav_host_fragment)

       // setupBottomNavMenu(navController)
    }

//    private fun setupBottomNavMenu(navController: NavController) {
//        binding.bottomNavView.let {
//            NavigationUI.setupWithNavController(it, navController)
//            it.setOnItemReselectedListener { item ->
//                if (item.isChecked) {
//                    return@setOnItemReselectedListener
//                }
//            }
//        }
//
//    }
}