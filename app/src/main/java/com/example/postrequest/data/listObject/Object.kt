package com.example.postrequest.data.listObject

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.example.postrequest.R

data class Object(
    var index: Int,
    @DrawableRes val imageObject: Int,
    var nameObject: String,
    var status: String,
    var colorStat: Color,
    var data: String
)
@RequiresApi(Build.VERSION_CODES.O)
val listObject = listOf<Object>(
    Object(0, R.drawable.object1, "Библиотека", listStatus[1].status, listStatus[1].color, "12-06-2022") ,
    Object(1, R.drawable.object2, "Школа", listStatus[2].status, listStatus[2].color, "08-04-2023")
)
