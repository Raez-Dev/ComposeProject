package com.raezcorp.composeproject.presentation.home

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.raezcorp.composeproject.data.model.BottomNavItem
import com.raezcorp.composeproject.navigation.home.ScreenHome
import com.raezcorp.composeproject.navigation.home.SetupNavGraphHome
import com.raezcorp.composeproject.presentation.common.components.BottomNavigationBar


@Composable
fun HomeScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = ScreenHome.Home.route,
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = ScreenHome.Chat.route,
                        icon = Icons.Default.Notifications
                    ),
                    BottomNavItem(
                        name = "Settings",
                        route = ScreenHome.Settings.route,
                        icon = Icons.Default.Settings
                    )
                ) ,
                navController = navController,
                onItemClick = { item ->
                    navController.navigate(item.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        },

        ) {
        SetupNavGraphHome(navController,it)
    }
}
