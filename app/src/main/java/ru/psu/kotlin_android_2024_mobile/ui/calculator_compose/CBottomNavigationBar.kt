package ru.psu.kotlin_android_2024_mobile.ui.calculator_compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CBottomNavigationBar(navController: NavHostController)
{
    val items = listOf(
        "calculator",
        "converter",
        "timer"
    )


    // observe the backstack
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // observe current route to change the icon
    // color,label color when navigated
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            items.forEach { item->
                IconButton(onClick = {
                    navController.navigate(item)
                }) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Localized description",
                        tint = if (item==currentRoute) Color.Yellow else Color.Green
                    )
                }
            }
        }
    )
}
