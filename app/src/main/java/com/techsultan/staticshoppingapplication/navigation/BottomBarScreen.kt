package com.techsultan.staticshoppingapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
) {
    data object Home: BottomBarScreen(
        route = "home",
        icon = Icons.Outlined.Home
    )
    data object Checkout: BottomBarScreen(
        route = "discovery",
        icon = Icons.Outlined.ShoppingCart
    )
}