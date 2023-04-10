package com.example.postrequest.navigation.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.postrequest.data.autorization.AuthManager
import com.example.postrequest.navigation.Screens

@Composable
fun ProfileScreen(
    authPrefs: AuthManager,
    navControllerMain: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            authPrefs.setIsAuthenticated(false)
            navControllerMain.navigate("autorization"){
                popUpTo("home"){inclusive = true}
            }

        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 84, green = 111, blue = 122)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Выйти из аккаунта", color = Color.White)
        }
    }
}