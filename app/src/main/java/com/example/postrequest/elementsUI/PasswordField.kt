package com.example.postrequest.elementsUI

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun passwordField(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
){
    var passwordVisible by remember { mutableStateOf(false) }

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
        placeholder = { Text(text = label, fontSize = 14.sp, color = Color.Black) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(image, contentDescription = null, tint = Color.Gray)
            }
        }
    )
}