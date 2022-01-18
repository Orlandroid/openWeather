package com.example.openweather.data.repository

import com.example.openweather.data.api.WebServices
import com.example.openweather.data.model.WeatherResponse
import javax.inject.Inject

class Repository @Inject constructor(private val webServices: WebServices) {

    suspend fun getWeatherResponse(latitude: String, longitude: String, appId: String):WeatherResponse =
        webServices.weatherResponse(latitude, longitude, appId)

}