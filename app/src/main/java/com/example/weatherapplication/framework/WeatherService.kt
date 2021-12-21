package com.example.weatherapplication.framework

import com.example.weatherapplication.framework.dto.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/onecall")
    suspend fun oneCall(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<BaseResponse>


}