package com.raezcorp.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.raezcorp.composeproject.navigation.SetUpNavGraph
import com.raezcorp.composeproject.ui.theme.ComposeProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                val navController = rememberNavController()
                SetUpNavGraph(navController = navController)

            }
        }
    }
}
