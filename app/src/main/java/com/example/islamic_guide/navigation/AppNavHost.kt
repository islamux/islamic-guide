package com.example.islamic_guide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.islamic_guide.ui.screens.HomeScreen
import com.example.islamic_guide.ui.screens.DetailsScreen
import com.example.islamic_guide.viewmodel.DaeeViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    viewModel: DaeeViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(
            route = "details/{daeeId}",
            arguments = listOf(navArgument("daeeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val daeeId = backStackEntry.arguments?.getInt("daeeId") ?: return@composable
            DetailsScreen(daeeId = daeeId)
        }
    }
}