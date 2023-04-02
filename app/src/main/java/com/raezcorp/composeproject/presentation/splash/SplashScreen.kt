package com.raezcorp.composeproject.presentation.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.raezcorp.composeproject.R
import com.raezcorp.composeproject.navigation.Screen
import com.raezcorp.composeproject.ui.theme.Purple500
import com.raezcorp.composeproject.ui.theme.Purple700

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val onBoardingCompleted by splashViewModel.onBoardingComplete.collectAsState()

    val degrees = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        navHostController.popBackStack()
        if (onBoardingCompleted) {
            navHostController.navigate(Screen.Login.route)
        } else {
            navHostController.navigate(Screen.Welcome.route)
        }
    }
    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float) {

    if (isSystemInDarkTheme()) {
        SplashContent(
            Modifier
                .background(
                    Color.Black
                )
                .fillMaxSize(),
            degrees
        )
    } else {
        SplashContent(
            Modifier
                .background(
                    Brush.verticalGradient(listOf(Purple700, Purple500))
                )
                .fillMaxSize(),
            degrees
        )
    }
}


@Composable
fun SplashContent(modifier: Modifier, degrees: Float) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.rotate(degrees),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashPreview() {
    Splash(degrees = 0f)
}