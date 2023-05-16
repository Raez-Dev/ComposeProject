package com.raezcorp.composeproject.presentation.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.raezcorp.composeproject.data.model.BottomNavItem


@Composable
fun BottomNavigationItem(
    selected:Boolean,
    onItemClick : (BottomNavItem) -> Unit,
    item:BottomNavItem,
    rowScope:RowScope
) {

    rowScope.BottomNavigationItem(
        selected = selected,
        onClick = { onItemClick(item) },
        selectedContentColor = Color.Green,
        unselectedContentColor = Color.Gray,
        icon = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                if (item.badgeCount > 0) {
                    BadgedBox(badge = {
                        Text(text = item.badgeCount.toString())
                    }) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                    }
                } else {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.name
                    )
                }

                if (selected) {
                    Text(
                        text = item.name,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp
                    )
                }


            }
        }
    )
}
