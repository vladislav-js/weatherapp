package com.example.weatherapp.presentation.theme.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun MainCard(temperature: Float, description: String, date:String) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(300.dp),

            elevation = CardDefaults.elevatedCardElevation(10.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFd8ebf0).copy(alpha = 0.7f)
            )
        ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = date,

                )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "$temperature" + "°",
//                    modifier = Modifier.padding(bottom = 10.dp),
                    fontSize = 60.sp,
                )
                Text(
                    text = description,
                    fontSize = 20.sp,

                )
            }

        }
    }
}
