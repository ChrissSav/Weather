package com.example.weatherapplication.data.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB

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