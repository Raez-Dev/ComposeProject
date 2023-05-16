package com.raezcorp.composeproject.presentation.common.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raezcorp.composeproject.data.model.BottomNavItem
import com.raezcorp.composeproject.ui.theme.LigthColorMain


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStateEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = LigthColorMain,
        elevation = 5.dp
    ) {

        items.forEach { item ->

            val selected = item.route == backStateEntry.value?.destination?.route

            BottomNavigationItem(
                selected = selected ,
                onItemClick = {
                    onItemClick(item)
                },
                item = item,
                rowScope = this
            )

            /*BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )

                    }
                }
            )*/

        }

    }

}
