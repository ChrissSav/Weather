package com.example.weatherapplication.util

import android.app.Activity
import android.widget.TextView
import com.example.weatherapplication.R
import com.tapadoo.alerter.Alerter


fun TextView.setAnyText(text: Any) {
    this.text = text.toString()
}

fun String.firstLetterUpperCase(): String {
    return this[0].toUpperCase() + this.substring(1)
}

fun Activity.createAlerter(msg: String) {
    var icon = R.drawable.ic_exclamation_mark
    if (this.resources.getString(R.string.ERROR_INTERNET_CONNECTION) == msg)
        icon = R.drawable.ic_no_wifi
    Alerter.create(this)
        .setTitle(getString(R.string.warning))
        .setText(msg)
        .setIcon(icon)
        .setBackgroundColorRes(R.color.primary)
        .setDuration(2500)
        .enableSwipeToDismiss() //seems to not work well with OnClickListener
        .show()
}
