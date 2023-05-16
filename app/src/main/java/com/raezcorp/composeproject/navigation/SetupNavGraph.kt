package com.raezcorp.composeproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raezcorp.composeproject.presentation.home.HomeScreen
import com.raezcorp.composeproject.presentation.login.LoginScreen
import com.raezcorp.composeproject.presentation.onboarding.WelcomeScreen
import com.raezcorp.composeproject.presentation.splash.SplashScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) { SplashScreen(navController) }
        composable(route = Screen.Welcome.route) { WelcomeScreen(navController) }
        composable(route = Screen.Login.route) { LoginScreen(navController) }
        composable(route = Screen.Home.route) { HomeScreen() }

    }
}

