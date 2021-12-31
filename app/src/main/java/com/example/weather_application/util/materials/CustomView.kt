package com.example.weather_application.util.materials

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weather_application.R
import com.example.weather_application.databinding.CustomViewBinding

class CustomView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var binding = CustomViewBinding.inflate(LayoutInflater.from(context), this, true)
    var customViewOnClickListener: CustomViewOnClickListener? = null

    var label: String? = null
        get() = binding.label.text.toString()
        set(value) {
            field = value
            binding.label.text = value
        }

    var title: String? = null
        get() = binding.label.text.toString()
        set(value) {
            field = value
            binding.title.text = value
        }

    init {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView)

        try {
            title = attributes.getString(R.styleable.CustomView_title)
            label = attributes.getString(R.styleable.CustomView_label)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        attributes.recycle()





        binding.root.setOnClickListener {
            customViewOnClickListener?.onClick()
        }

    }
}

interface CustomViewOnClickListener {
    fun onClick()
}