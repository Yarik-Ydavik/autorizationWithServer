package com.example.postrequest.elementsUI

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun textField(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
){
    OutlinedTextField(
        value = text,
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = Color.Black,
            textDecoration = TextDecoration.None
        ),
        onValueChange = { it ->
            onTextChange (it)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.LightGray,
            backgroundColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Color.Black
        ),
        label = { Text(text = label, fontSize = 14.sp, color = Color.Gray) },
    )
}
