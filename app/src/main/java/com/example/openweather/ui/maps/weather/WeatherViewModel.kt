package com.example.openweather.ui.maps.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweather.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun getWeatherResponse(latitude: String, longitude: String, appId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getWeatherResponse(latitude, longitude, appId)
            if (response.isSuccessful) {
                Log.w("RESPONSE", response.body().toString())
            }
        }
    }
}