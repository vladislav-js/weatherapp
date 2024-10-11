package com.example.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.theme.ui.Input
import com.example.weatherapp.presentation.theme.ui.MainCard
import com.example.weatherapp.presentation.theme.ui.BackgroundImageScreen
import com.example.weatherapp.data.WeatherApiConnection


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherApiConnection("London")
            Box(modifier = Modifier.fillMaxSize()) {
                BackgroundImageScreen() // Вызов фонового изображения

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp) // Отступы для элементов UI
                ) {
                    Input()
                    MainCard()
                }
            }
        }
    }
}