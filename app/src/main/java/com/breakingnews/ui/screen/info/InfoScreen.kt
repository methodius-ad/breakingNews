package com.breakingnews.ui.screen.info

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.breakingnews.ui.navigation.Screen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun InfoScreen(navController: NavController) {
    val viewModel = koinViewModel<InfoViewModel> {
        parametersOf(navController.previousBackStackEntry?.savedStateHandle)
    }
    val context = LocalContext.current
    val timeState = viewModel.timeFlow.collectAsState()

    LaunchedEffect(key1 = Unit) {
        Toast.makeText(context, "Info Screen Opened", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Info Screen"
        )
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = timeState.value.toString()
        )
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Home Screen last time: ${viewModel.homeScreenLastTime}"
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Menu.route)
            },
            text = "Navigate to Menu Screen"
        )
    }
}