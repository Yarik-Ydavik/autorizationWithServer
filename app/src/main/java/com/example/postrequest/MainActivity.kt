package com.example.postrequest

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.postrequest.data.autorization.AuthManager
import com.example.postrequest.navigation.Screens
import com.example.postrequest.navigation.SetupNavController
import com.example.postrequest.ui.theme.PostRequestTheme


import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    private val authPrefs by lazy {AuthManager(this)}
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostRequestTheme {
                val navController: NavHostController = rememberNavController()
                if (authPrefs.getIsAuthenticated()){
                    SetupNavController(
                        navController = navController,
                        authPrefs = authPrefs,
                    )
                }
                else{
                    SetupNavController(
                        navController = navController,
                        authPrefs = authPrefs,
                        startDestination =  Screens.Autorization.route
                    )
                }

            }
        }

    }

}







