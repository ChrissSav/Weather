package com.example.weatherapplication.util

import android.widget.TextView


fun TextView.setAnyText(text: Any) {
    this.text = text.toString()
}

fun String.firstLetterUpperCase(): String {
    return this[0].toUpperCase() + this.substring(1)
}