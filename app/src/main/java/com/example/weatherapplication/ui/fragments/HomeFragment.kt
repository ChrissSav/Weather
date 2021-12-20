package com.example.weatherapplication.ui.fragments

import com.example.weatherapplication.data.base.BaseFragment
import com.example.weatherapplication.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUpObservers() {
    }

    override fun setUpViews() {
    }
}