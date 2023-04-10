package com.example.postrequest.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.postrequest.data.autorization.AuthManager
import com.example.postrequest.navigation.page.AutorizationScreen
import com.example.postrequest.navigation.page.HomeScreen
import com.example.postrequest.navigation.page.ProfileScreen
import com.example.postrequest.navigation.page.StartScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavController(
    navController: NavHostController,
    startDestination: String = Screens.Home.route,
    authPrefs: AuthManager,
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable( route = Screens.Home.route){
            HomeScreen(
                navControllerMain = navController,
                authPrefs = authPrefs
            )
        }

        composable( route = Screens.Autorization.route){
            AutorizationScreen(
                navController = navController,
            )
        }

    }
}