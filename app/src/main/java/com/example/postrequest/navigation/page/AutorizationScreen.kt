package com.example.postrequest.navigation.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.postrequest.data.autorization.AuthManager
import com.example.postrequest.elementsUI.passwordField
import com.example.postrequest.elementsUI.textField
import com.example.postrequest.navigation.Screens
import com.example.postrequest.navigation.SetupNavController
import kotlinx.coroutines.runBlocking

@Composable
fun AutorizationScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    val context = LocalContext.current

    var authManage = AuthManager(context)
    var phoneNum by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var num = "1"
    var pas = "1"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 96, green = 125, blue = 139)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        textField(label = "Номер телефона", text = phoneNum, onTextChange = {it -> phoneNum = it})
        Spacer(modifier = Modifier.height(10.dp))
        passwordField(label = "Пароль", text = password, onTextChange = {it -> password = it})
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            runBlocking {
/*
                com.example.postrequest.network.request.Autorization().postAutorization(phoneNum, password).toString() == "200"
*/
                if (phoneNum == num && password == pas){
                    authManage.setIsAuthenticated(true)
                    navController.navigate(Screens.Home.route){
                        popUpTo("autorization"){inclusive = true}
                    }
                }
            }
        }, shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(backgroundColor = Color(red = 84, green = 111, blue = 122)), modifier = Modifier.size(width = 200.dp, height = 80.dp)) {
            Text(text = "Авторизация", color = Color.White)
        }

    }
}


