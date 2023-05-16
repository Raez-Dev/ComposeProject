package com.raezcorp.composeproject.navigation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raezcorp.composeproject.presentation.category.CategoryScreen
import com.raezcorp.composeproject.presentation.chat.ChatScreen
import com.raezcorp.composeproject.presentation.settings.SettingsScreen


@Composable
fun SetupNavGraphHome(navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = ScreenHome.Home.route){

        composable(route = ScreenHome.Home.route){
            CategoryScreen()
        }
        composable(route = ScreenHome.Chat.route){
            ChatScreen()
        }
        composable(route = ScreenHome.Settings.route){
            SettingsScreen()
        }


    }

}
