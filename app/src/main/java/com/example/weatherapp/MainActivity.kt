package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.theme.ui.CustomTextButton
import com.example.weatherapp.presentation.theme.ui.MainCard
import com.example.weatherapp.presentation.theme.ui.BackgroundImageScreen
import com.example.weatherapp.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Инициализация получения погоды для определенного города
        weatherViewModel.fetchWeather(this, "Temirtau")

        setContent {
            WeatherScreen(viewModel = weatherViewModel) // Используйте WeatherScreen
        }
    }
}

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherData by viewModel.weatherData.observeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImageScreen()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CustomTextButton("Temirtau")
            }

            // Проверка, что данные о погоде загружены, если даные загружены, то стартует карточка с данными
            weatherData?.let { weatherModel ->
                MainCard(
                    temperature = weatherModel.currentTemp.toFloat(),
                    description = weatherModel.description,
                    date = weatherModel.date
                )
                // Если данные не пришли, выходит следующая надпись:
            } ?: run {
                Text(text = "Загрузка...")
            }
        }
    }
}
