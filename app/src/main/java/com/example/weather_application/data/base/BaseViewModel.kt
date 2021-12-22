package com.example.weather_application.data.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_application.R
import com.example.weather_application.framework.NoInternetException
import com.example.weather_application.framework.exc.ErrorMessage
import com.example.weather_application.framework.exc.internalError
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val error = SingleLiveEvent<ErrorMessage>()
    val load = MutableLiveData<Boolean>()


    fun <T : Any> launch(function: suspend () -> T) {
        viewModelScope.launch {
            try {
                load.value = true
                function.invoke()
                load.value = false
            } catch (errorExc: Exception) {
                load.value = false
                when (errorExc) {
                    is NoInternetException -> {
                        error.value = internalError(R.string.ERROR_INTERNET_CONNECTION)
                    }
                    else -> {
                        error.value = internalError(R.string.ERROR_SOMETHING_WRONG)
                    }
                }
            }
        }
    }

}