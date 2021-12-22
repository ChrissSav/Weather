package com.example.weather_application.data.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


abstract class BaseActivityViewModel<VB : ViewBinding, VM : BaseViewModel>(clazz: Class<VM>) : AppCompatActivity() {

    lateinit var binding: VB
    val viewModel: VM by lazy { ViewModelProvider(this).get(clazz) }


    abstract fun provideViewBinding(): VB

    abstract fun setUpObservers()

    abstract fun setUpViews()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = provideViewBinding()
        setContentView(binding.root)

        setUpViews()
        setUpObservers()
    }


}