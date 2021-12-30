package com.example.weather_application.framework.utils

import androidx.lifecycle.MutableLiveData
import com.example.weather_application.framework.BaseApiException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

fun <T : Any> Response<T>.handleCall(): T {
    val body = body()
    return if (isSuccessful && body != null) {
        body
    } else {
        throw BaseApiException(text = "getErrorResponseErrorBody(errorBody())")
    }
}


suspend fun <T : Any> networkCall(
    function: suspend () -> T
): T {
    return withContext(Dispatchers.IO) {
        try {
            function.invoke()
        } catch (exception: BaseApiException) {
            throw exception
        }
    }
}


suspend fun <T : Any> roomCall(
    function: suspend () -> T
): T =
    withContext(Dispatchers.IO) {
        function.invoke()
    }


fun <T : Any> MutableLiveData<MutableList<T>>.addItem(item: T) {
    val temp = this.value ?: mutableListOf()
    temp.add(item)
    this.value = temp
}