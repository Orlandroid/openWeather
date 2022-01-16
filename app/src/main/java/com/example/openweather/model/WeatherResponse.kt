package com.example.openweather.model

data class WeatherResponse(
    val hola:String
){

    data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    )
    data class MainTempeture(
        val temp_min: Int,
        val temp_max: Int,
        val humidity: Int
    )
    data class Wind(
        val speed:Int,
        val deg:Int,
        val gust:Int
    )
    data class Sys(
        val country:String
    )
}

