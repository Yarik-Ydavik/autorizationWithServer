package com.example.postrequest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.postrequest.navigation.page.AutorizationScreen
import com.example.postrequest.navigation.page.HomeScreen
import com.example.postrequest.navigation.page.PaymentScreen
import com.example.postrequest.navigation.page.RegistrationScreen
import com.example.postrequest.utils.Constants

sealed class Screens (val route: String){
    object Home: Screens(route = Constants.Screens.SCREEN_HOME)
    object Registration: Screens(route = Constants.Screens.SCREEN_REGISTRATION)
    object Autorization:Screens(route = Constants.Screens.SCREEN_AUTORIZATION)
    object Payment: Screens(route = Constants.Screens.SCREEN_PAYMENT)
}

@Composable
fun SetupNavController(
    navController: NavHostController,
    startDestination: String = Screens.Home.route,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable( route = Screens.Home.route){
            HomeScreen(
                onNavigationToRegistration = {navController.navigate(Screens.Registration.route)},
                onNavigationToAutorization = {navController.navigate(Screens.Autorization.route)},
            )
        }
        composable( route = Screens.Registration.route){
            RegistrationScreen(
                navController = navController
            ) { navController.navigate(Screens.Payment.route) }
        }
        composable( route = Screens.Autorization.route){
            AutorizationScreen(
                navController = navController,
                onNavigationToPayment = { navController.navigate(Screens.Payment.route) },
            )
        }
        composable( route = Screens.Payment.route){
            PaymentScreen(
                navController = navController
            )
        }
    }
}