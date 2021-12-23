package com.example.weather_application.ui.fragments

import com.example.weather_application.data.base.BaseFragment
import com.example.weather_application.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {


    override fun getViewBinding(): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater)

    override fun setUpObservers() {
    }

    override fun setUpViews() {
    }
}