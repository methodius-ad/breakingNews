package com.breakingnews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.breakingnews.ui.screen.home.HomeScreen
import com.breakingnews.ui.screen.info.InfoScreen
import com.breakingnews.ui.screen.menu.MenuScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Info.route) {
            InfoScreen(navController = navController)
        }

        composable(route = Screen.Menu.route) {
            MenuScreen(navController = navController)
        }
    }
}