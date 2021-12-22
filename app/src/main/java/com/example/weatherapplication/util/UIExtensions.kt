package com.example.weatherapplication.util

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.weatherapplication.R
import com.tapadoo.alerter.Alerter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


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

fun TextView.typeWrite(lifecycleOwner: LifecycleOwner, text: String, intervalMs: Long, function: () -> Unit) {
    this@typeWrite.text = ""
    lifecycleOwner.lifecycleScope.launch {
        repeat(text.length) {
            delay(intervalMs)
            this@typeWrite.text = text.take(it + 1)
        }
        delay(intervalMs)
        function.invoke()
    }
}

fun Activity.openActivityWithFade(intent: Intent) {
    startActivity(intent)
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    finish()
}
