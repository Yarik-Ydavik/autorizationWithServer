package com.example.postrequest.navigation.page

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.postrequest.elementsUI.textField
import com.example.postrequest.network.request.Registration
import kotlinx.coroutines.runBlocking

@Composable
fun RegistrationScreen(navController: NavHostController, onNavigationToPayment: () -> Unit) {
    var txt: String by remember { mutableStateOf("Wait") }

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column() {
        textField(label = "Ваше имя", text = name, onTextChange = {value -> name = value})
        Spacer(modifier = Modifier.height(10.dp))
        textField(label = "Ваша фамилия", text = surname, onTextChange = {value -> surname = value})
        Spacer(modifier = Modifier.height(10.dp))
        textField(label = "Ваша почта", text = mail, onTextChange = {value -> mail = value})
        Spacer(modifier = Modifier.height(10.dp))
        textField(label = "Ваш пароль", text = password, onTextChange = {value -> password = value})
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            runBlocking {
                txt = Registration().postRegistration(name,surname,mail,password)
                Log.e("start",txt)
            }
        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 13, green = 110, blue = 253)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Зарегестрироваться", color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = txt)
        Spacer(modifier = Modifier.height(10.dp))
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