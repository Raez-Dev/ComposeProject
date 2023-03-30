package com.raezcorp.composeproject.navigation

sealed class Screen(val route:String) {

    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Login: Screen("login_screen")

}
