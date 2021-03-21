package com.example.androiddevchallenge

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import java.util.*

sealed class Screen(val route: String) {
    object Welcome : Screen("Welcome")
    object Login : Screen("Login")
    object Home : Screen("Home")
}

data class NavItem(val icon: ImageVector, val title: String)

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        NavItem(Icons.Default.Spa, "Home"),
        NavItem(Icons.Default.AccountCircle, "Profile")
    )
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

        items.mapIndexed { index, navItem ->
            BottomNavigationItem(selected = index % 2 == 0, onClick = { },
                icon = {
                    Icon(navItem.icon, contentDescription = navItem.title.toUpperCase(Locale.ROOT))
                },
                label = {
                    Text(text = navItem.title, style = MaterialTheme.typography.caption)
                })
        }
    }
}