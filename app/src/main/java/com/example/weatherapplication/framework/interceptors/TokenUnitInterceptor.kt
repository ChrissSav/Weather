package com.example.weatherapplication.framework.interceptors

import com.example.weatherapplication.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*


class TokenUnitInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()

        val url: HttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("units", "metric")
            .addQueryParameter("lang", Locale.getDefault().language)
            .addQueryParameter("appid", BuildConfig.ACCESS_TOKEN).build()

        return chain.proceed(originalRequest.newBuilder().url(url).build())

    }
}