package com.example.weather_application.framework

import com.example.weather_application.framework.dto.BaseResponse
import com.example.weather_application.framework.dto.DirectResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/onecall")
    suspend fun oneCall(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<BaseResponse>

    @GET("geo/1.0/reverse")
    suspend fun reverseGeocode(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<BaseResponse>

    @GET("geo/1.0/direct")
    suspend fun geocode(
        @Query("q") query: String
    ): Response<MutableList<DirectResponse>>
}