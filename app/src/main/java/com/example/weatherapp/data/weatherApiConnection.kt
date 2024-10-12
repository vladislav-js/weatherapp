package com.example.weatherapp.data

import android.content.Context
import android.util.Log
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

    fun fetchWeather() {
        val request = StringRequest(
            Request.Method.GET,
            url,
            { result ->
                Log.d("MyLog", "Result: $result")
            },
            { error ->
                Log.e("MyLog", "Error: ${error.networkResponse?.statusCode}, Message: ${error.message}, Cause: ${error.cause}")
            }
        )
        queue.add(request)
    }
}
