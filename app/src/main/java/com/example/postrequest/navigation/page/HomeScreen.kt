package com.example.postrequest.navigation.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onNavigationToRegistration: () -> Unit,
    onNavigationToAutorization: () -> Unit,
) {
    Column() {
        Button(onClick = {
            onNavigationToRegistration()
        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Регистрация", color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            onNavigationToAutorization()
        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Авторизация", color = Color.White)
        }

    }
}