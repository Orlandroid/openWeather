package com.example.openweather.model

import android.accounts.AuthenticatorDescription

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)


