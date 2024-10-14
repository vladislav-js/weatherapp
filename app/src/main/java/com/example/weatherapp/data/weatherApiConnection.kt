
package com.example.weatherapp.data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

const val API_KEY = "73ba345f96a1492d8f0165822241110"

class WeatherApiConnection(private val city: String) {
    private lateinit var queue: RequestQueue

    fun init(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    private val url = "https://api.weatherapi.com/v1/forecast.json" +
            "?key=$API_KEY" +
            "&q=$city" +
            "&days=3" +
            "&aqi=no&alerts=no"

    fun fetchWeather(callback: (WeatherModel) -> Unit) {
        val request = StringRequest(
            Request.Method.GET,
            url,
            { result ->
                val weatherModel = ParseWeatherData(result)
                callback(weatherModel) // Вызов обратного вызова с результатом
            },
            { error ->
                Log.e(
                    "MyLog",
                    "Ошибка: ${error.networkResponse?.statusCode}, Сообщение: ${error.message}, Причина: ${error.cause}"
                )
            }
        )
        queue.add(request)
    }
}
