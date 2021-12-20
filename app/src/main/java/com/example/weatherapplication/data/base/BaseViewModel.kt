package com.example.weatherapplication.data.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.R
import com.example.weatherapplication.framework.*
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
                    is BaseApiException -> {
                        if (errorExc.stringCode == null) {
                            error.value = externalError(errorExc.text.toString())
                        } else {
                            error.value = internalError(errorExc.stringCode)
                        }
                    }
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