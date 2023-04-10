package com.example.postrequest.elementsUI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun dropDownField(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    param1: String,
    param2: String,
    param3: String,
    param4: String
){

    var dropDpwnCheck = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = Color.Black,
            textDecoration = TextDecoration.None
        ),
        onValueChange = { it->
            onTextChange (it)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.LightGray,
            backgroundColor = Color.White,
            unfocusedIndicatorColor = Color.LightGray,
            cursorColor = Color.Black
        ),
        modifier = modifier,
        trailingIcon = {
            Icon( Icons.Default.ArrowDropDown , contentDescription = null, modifier = modifier.clickable { dropDpwnCheck.value = true }, tint = Color.Black)
        },
        placeholder = { Text(text = label, fontSize = 14.sp, color = Color.Black) },
    )

    DropdownMenu(expanded = dropDpwnCheck.value, onDismissRequest = { dropDpwnCheck.value = false }, modifier = modifier
        .background(Color.White)
        .fillMaxWidth(0.95f)) {
        DropdownMenuItem(onClick = {
            onTextChange (param1)
            dropDpwnCheck.value = false
        }) {
            Text(text = param1, modifier= modifier.fillMaxWidth() , fontSize=18.sp, color = Color.Black)
        }
        DropdownMenuItem(onClick = {
            onTextChange (param2)
            dropDpwnCheck.value = false
        }) {
            Text(text = param2, modifier= modifier.fillMaxWidth() , fontSize=18.sp, color = Color.Black)
        }
        DropdownMenuItem(onClick = {
            onTextChange (param3)
            dropDpwnCheck.value = false
        }) {
            Text(text = param3, modifier= modifier.fillMaxWidth() , fontSize=18.sp, color = Color.Black)
        }
        DropdownMenuItem(onClick = {
            onTextChange (param4)
            dropDpwnCheck.value = false
        }) {
            Text(text = param4, modifier= modifier.fillMaxWidth() , fontSize=18.sp, color = Color.Black)
        }

    }
}