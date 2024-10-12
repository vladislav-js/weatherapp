package com.example.weatherapp.presentation.theme.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button as MaterialButton

@Composable
fun CustomTextButton() {
    var showDialog by remember { mutableStateOf(false) }

    Row(horizontalArrangement = Arrangement.Center) {
        TextButton(
            onClick = { showDialog = true },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Выбрать Город",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }


        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(text = "Выберите город")
                },
                text = {
                    Text("Выберите ваш город...")
                },
                confirmButton = {
                    MaterialButton(
                        onClick = {

                            showDialog = false
                            // добавить логику
                        }
                    ) {
                        Text("ОК")
                    }
                },
                dismissButton = {
                    MaterialButton(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("Отмена")
                    }
                }
            )
        }
    }
}
