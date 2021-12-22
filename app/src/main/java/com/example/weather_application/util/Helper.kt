package com.example.weather_application.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
fun convertTimestampToFormat(time: Long, format: String): String {
    val date = if (time.toString().length == 10)
        Date(time * 1000L)
    else
        Date(time)
    return SimpleDateFormat(format).format(date)
}


fun currentTimeStamp(): Long {
    return System.currentTimeMillis() / 1000L
}

fun convertCurrentTimestampToFormat(format: String): String {
    return convertTimestampToFormat(currentTimeStamp(), format)
}