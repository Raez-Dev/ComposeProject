package com.raezcorp.composeproject.presentation.onboarding

import androidx.annotation.DrawableRes
import com.raezcorp.composeproject.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
){
    object First:OnBoardingPage(
        image = R.drawable.greetings,
        title = "Grettings",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the "
    )
    object Second:OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letrase"
    )
    object Third:OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampd"
    )
}
