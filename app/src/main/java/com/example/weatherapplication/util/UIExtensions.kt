package com.example.weatherapplication.util

import android.widget.TextView


fun TextView.setAnyText(text: Any) {
    this.text = text.toString()
}