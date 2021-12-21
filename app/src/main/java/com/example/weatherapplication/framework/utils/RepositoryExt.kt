package com.example.weatherapplication.framework.utils

import com.example.weatherapplication.framework.BaseApiException
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




