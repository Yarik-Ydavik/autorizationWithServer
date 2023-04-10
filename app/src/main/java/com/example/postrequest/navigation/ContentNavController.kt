package com.example.postrequest.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.postrequest.data.autorization.AuthManager
import com.example.postrequest.data.listObject.listObject
import com.example.postrequest.navigation.page.ObjectScreen
import com.example.postrequest.navigation.page.PhotoScreen
import com.example.postrequest.navigation.page.ProfileScreen
import com.example.postrequest.navigation.page.StartScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentNavController(
    navController: NavHostController,
    startDestination: String,
    authPrefs: AuthManager,
    navControllerMain: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){

        composable( route = Screens.Start.route ){
            StartScreen(
                listOfobject = listObject,
                navController = navController
            )
        }
        composable( route = Screens.Profile.route ){
            ProfileScreen(authPrefs = authPrefs, navControllerMain = navControllerMain)
        }


        composable(
            route = Screens.Object.route+ "/{id}" ,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ){ backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("id")
            val card = listObject.first { it.index.toString() == cardId }
            ObjectScreen( cardinfo = card, navController = navController )
        }

        composable(route = "gallery"){
            PhotoScreen()
        }
    }
}