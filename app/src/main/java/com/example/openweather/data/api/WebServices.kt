package com.example.openweather.data.api

import com.example.openweather.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("weather/")
    suspend fun weatherResponse(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("appid") appId: String
    ): Response<WeatherResponse>

}