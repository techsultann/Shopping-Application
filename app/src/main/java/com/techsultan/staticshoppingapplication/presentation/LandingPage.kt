package com.techsultan.staticshoppingapplication.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.techsultan.staticshoppingapplication.navigation.HomeNavGraph
import com.techsultan.staticshoppingapplication.ui.theme.component.BottomNavigation

@Composable
fun LandingPage() {
    val navHostController = rememberNavController()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomNavigation(navController = navHostController)
        },
        content = { padding ->
            HomeNavGraph(
                modifier = Modifier.padding(padding),
                navHostController = navHostController,
            )

        }
    )
}