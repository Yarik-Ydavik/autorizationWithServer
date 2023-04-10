package com.example.postrequest.navigation

import com.example.postrequest.R
import com.example.postrequest.utils.Constants

sealed class Screens (var route: String, var icon: Int, var title:String){
    object Home: Screens(route = Constants.Screens.SCREEN_HOME, icon =0 , title = "Домашняя страница")
    object Autorization:Screens(route = Constants.Screens.SCREEN_AUTORIZATION,icon =0,title ="Авторизация")
    object Start:Screens (route = Constants.Screens.SCREEN_START, icon = R.drawable.home , title = "Главная")
    object Profile:Screens(route = Constants.Screens.SCREEN_PROFILE,icon = R.drawable.person,title ="Профиль")
    object Object: Screens(route = Constants.Screens.SCREEN_OBJECT,0,title ="Объект")
}
