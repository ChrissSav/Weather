package com.example.weatherapplication.ui

import android.content.Intent
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.NavController
import com.example.weatherapplication.R
import com.example.weatherapplication.data.base.BaseActivity
import com.example.weatherapplication.databinding.ActivitySplashBinding
import com.example.weatherapplication.util.openActivityWithFade
import com.example.weatherapplication.util.typeWrite

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private lateinit var navController: NavController

    override fun provideViewBinding(): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun setUpObservers() {


    }

    override fun setUpViews() {


        binding.label.typeWrite(this, getString(R.string.app_name), 200, {
            binding.motion.transitionToEnd()
        })

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