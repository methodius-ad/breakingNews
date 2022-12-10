package com.breakingnews.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")

    object Info : Screen(route = "info") {
        const val HOME_SCREEN_LAST_TIME_KEY = "HOME_SCREEN_LAST_TIME_KEY"
    }

    object Menu : Screen(route = "menu")
}