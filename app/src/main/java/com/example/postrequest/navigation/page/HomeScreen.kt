package com.example.postrequest.navigation.page

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.postrequest.data.autorization.AuthManager
import com.example.postrequest.data.listObject.listObject
import com.example.postrequest.navigation.ContentNavController
import com.example.postrequest.navigation.Screens

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    authPrefs: AuthManager,
    navControllerMain: NavHostController,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = { topBar() },
        bottomBar = { bottomBar( navController = navController ) },
        content = { padding->
            Box(modifier = Modifier.fillMaxSize().background(Color.White).padding(padding)) {
                ContentNavController(
                    navController = navController,
                    navControllerMain = navControllerMain,
                    startDestination = Screens.Start.route,
                    authPrefs = authPrefs
                )
            }
        }
    )
}

@Composable
fun topBar(){
    TopAppBar(
        title = { Text(text = "Сервис", fontSize = 18.sp) },
        backgroundColor = Color(red = 38, green = 52, blue = 55),
        contentColor = Color.White
    )

}

@Composable
fun bottomBar(navController: NavHostController) {
    val items = listOf(
        Screens.Start,
        Screens.Profile
    )
    BottomNavigation(
        backgroundColor = Color(red = 38, green = 52, blue = 55)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach{item ->
            BottomNavigationItem(
                icon = { Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.title,
                    modifier = Modifier.size(20.dp)
                ) },
                label = { Text(text = item.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

