package com.example.weatherapp.data

import android.util.Log
import org.json.JSONObject

fun ParseWeatherData(result: String): WeatherModel {
    val mainObject = JSONObject(result)


    val currentTemp = mainObject.getJSONObject("current").getString("temp_c")
    val description = mainObject.getJSONObject("current").getJSONObject("condition").getString("text")
    val firstDay = mainObject.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(0)
    val date = firstDay.getString("date")


    return WeatherModel(currentTemp, description, date)
}
