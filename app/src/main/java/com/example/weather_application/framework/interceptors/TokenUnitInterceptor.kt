package com.example.weather_application.framework.interceptors

import com.example.weather_application.BuildConfig
import com.example.weather_application.util.getAppLanguage
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class TokenUnitInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()

        val url: HttpUrl = originalRequest.url.newBuilder()
            .addQueryParameter("units", "metric")
            .addQueryParameter("lang", getAppLanguage())
            .addQueryParameter("appid", BuildConfig.ACCESS_TOKEN).build()

        return chain.proceed(originalRequest.newBuilder().url(url).build())

    }
}