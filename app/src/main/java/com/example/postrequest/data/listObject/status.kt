package com.example.postrequest.data.listObject

import androidx.compose.ui.graphics.Color

data class status(
    var status: String,
    var color: Color
)
val listStatus = listOf<status>(
    status(status = "Новый", color = Color(red = 112, green = 255, blue = 0)),
    status(status = "В работе", color = Color(red = 255, green = 184, blue = 0)),
    status(status = "Завершён", color = Color.Gray)
)