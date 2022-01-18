package com.example.openweather.data.model

data class WeatherResponse(
    val weather: List<Weather>,
    val main: MainTempeture,
    val wind: Wind,
    val sys: Sys
) {

    data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    )

    data class MainTempeture(
        val temp: Float,
        val temp_min: Float,
        val temp_max: Float,
        val humidity: Int
    )

    data class Wind(
        val speed: Float,
        val deg: Int,
        val gust: Float
    )

    data class Sys(
        val country: String
    )
}

