package com.example.weatherapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.WeatherApiConnection
import com.example.weatherapp.data.WeatherModel

class WeatherViewModel : ViewModel() {
    // Переменная где хранятся данные и меняется их значение
    private val _weatherData = MutableLiveData<WeatherModel>()
    // Св-во которое дает доступ в виде лайв данных
    val weatherData: LiveData<WeatherModel> get() = _weatherData

    fun fetchWeather(context: Context, city: String) {
        // Экземпляр получающий данные о погоде
        val apiConnection = WeatherApiConnection(city)
        apiConnection.init(context) // Передача контекста
        apiConnection.fetchWeather { weatherModel ->
            _weatherData.value = weatherModel
        }
    }
}