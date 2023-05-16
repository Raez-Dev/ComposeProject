package com.raezcorp.composeproject.navigation.home

sealed class ScreenHome(val route:String){

    object Home : ScreenHome("home_screen")
    object Chat : ScreenHome("chat_screen")
    object Settings : ScreenHome("settings_screen")


}

