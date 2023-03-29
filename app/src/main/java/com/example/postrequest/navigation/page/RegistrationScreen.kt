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
import androidx.navigation.NavHostController

@Composable
fun RegistrationScreen(navController: NavHostController, onNavigationToPayment: () -> Unit) {
    Column() {
        Button(onClick = {
            onNavigationToPayment()
        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Перейти к оплате", color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.popBackStack() }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Вернуться назад", color = Color.White)
        }

    }

}