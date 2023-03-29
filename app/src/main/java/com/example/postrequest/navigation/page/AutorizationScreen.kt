package com.example.postrequest.navigation.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.postrequest.elementsUI.textField
import com.example.postrequest.network.request.Autorization
import kotlinx.coroutines.runBlocking

@Composable
fun AutorizationScreen(navController: NavHostController, onNavigationToPayment: () -> Unit, modifier: Modifier = Modifier) {
    var mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var txt by remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        textField(label = "Ваша почта", text = mail, onTextChange = {value -> mail = value})
        Spacer(modifier = Modifier.height(10.dp))
        textField(label = "Ваш пароль", text = password, onTextChange = {value -> password = value})
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { runBlocking { txt = Autorization().postAutorization(mail, password) } }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253))) {
            Text(text = "Авторизоваться", color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = txt)


        Button(onClick = {
            onNavigationToPayment()
        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253))) {
            Text(text = "Перейти к оплате", color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.popBackStack() }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253))) {
            Text(text = "Вернуться назад", color = Color.White)
        } 
    }
    
}


