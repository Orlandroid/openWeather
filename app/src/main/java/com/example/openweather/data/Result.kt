package com.example.openweather.data

sealed class Result<out R> {

    class Success<out T>(val data: T) : Result<T>()
    class Error<out T>(val error: Exception) : Result<T>()
    class ErrorNetwork<out T>(error: String) : Result<T>()
    object Loading : Result<Nothing>()

}