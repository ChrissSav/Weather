package com.example.weather_application.ui

import android.content.Intent
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import com.example.weather_application.data.base.BaseActivity
import com.example.weather_application.databinding.ActivitySplashBinding
import com.example.weather_application.util.openActivityWithFade
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private lateinit var navController: NavController

    override fun provideViewBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun setUpObservers() {


    }

    override fun setUpViews() {


        lifecycleScope.launch {
            delay(1000L)
            binding.motion.transitionToEnd()
        }


        binding.motion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                openActivityWithFade(Intent(this@SplashActivity, MainActivity::class.java))
            }

            override fun onTransitionTrigger(motionLayout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {
            }

            override fun onTransitionStarted(motionLayout: MotionLayout?, startId: Int, endId: Int) {
            }

            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
            }
        })

    }
}