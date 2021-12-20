package com.example.weatherapplication.framework

import okhttp3.Interceptor
import okhttp3.Response
import java.net.InetAddress

class NetworkConnectionInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        return try {
            val address = InetAddress.getByName("google.com")
            //You can replace it with your name
            if (!address.equals("")) {
                chain.proceed(chain.request())
            } else {
                throw NoInternetException()
            }
        } catch (e: Exception) {
            throw NoInternetException()
        }


    }

}