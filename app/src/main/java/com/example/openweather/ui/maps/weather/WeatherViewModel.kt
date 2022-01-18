package com.example.openweather.ui.maps.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweather.data.model.WeatherResponse
import com.example.openweather.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.openweather.data.Result
import kotlinx.coroutines.withContext


@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _weatherResponse = MutableLiveData<Result<WeatherResponse>>()
    val weatherResponse: LiveData<Result<WeatherResponse>> get() = _weatherResponse

    fun getWeatherResponse(latitude: String, longitude: String, appId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _weatherResponse.value = Result.Loading
                val response = repository.getWeatherResponse(latitude, longitude, appId)
                _weatherResponse.value = Result.Success(response)
            }
        }
    }
}