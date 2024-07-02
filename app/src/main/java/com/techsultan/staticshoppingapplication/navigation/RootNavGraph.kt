package com.techsultan.staticshoppingapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.techsultan.staticshoppingapplication.MainViewModel
import com.techsultan.staticshoppingapplication.presentation.CheckOutScreen
import com.techsultan.staticshoppingapplication.presentation.HomeScreen
import com.techsultan.staticshoppingapplication.presentation.LandingPage
import com.techsultan.staticshoppingapplication.presentation.OrderSuccessfulScreen
import com.techsultan.staticshoppingapplication.presentation.WelcomeScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.WelcomeScreen.route,
        route = Graph.ROOT
    ) {
        composable(route = Screens.WelcomeScreen.route) {
            WelcomeScreen(navHostController = navHostController)
        }
        composable(route = Graph.HOME) {
            LandingPage()
        }
    }
}

@Composable
fun HomeNavGraph(
    modifier: Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route,
        route = Graph.HOME
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.Checkout.route) {
            CheckOutScreen(navHostController)
        }
        composable(Screens.Successful.route) {
            OrderSuccessfulScreen(navHostController = navHostController)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
}

sealed class Screens(val route: String) {
    data object WelcomeScreen : Screens(route = "welcome")
    data object HomeScreen : Screens(route = "home")
    data object Checkout : Screens(route = "checkout")
    data object Successful: Screens(route = "successful")
}