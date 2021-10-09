package com.example.openweather.model

data class Weather(val coord: Coord, val weather: Weathers) {
    data class Coord(val lon: String, val lat: String)
    data class Weathers(val main: String, val description: String, val icon: String)
}
