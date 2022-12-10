package com.breakingnews.ui.screen.menu

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(navController: NavController) {
    val viewModel = koinViewModel<MenuViewModel>()
    val userDataState = viewModel.userDataFlow.collectAsState()
    var isVisible by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 45.dp)
            .clickable {
                isVisible = !isVisible
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(
            items = userDataState.value,
            key = { _, item -> item }
        ) { index, userData ->
            UserDataItem(userData, index) {
                navController.popBackStack()
            }
        }
    }

    CenterText(isVisible)
}

@Composable
private fun UserDataItem(
    userData: String,
    index: Int,
    onClick: () -> Unit
) {
    val isClickable by remember { mutableStateOf(index == 1) }

    Text(
        text = userData,
        modifier = Modifier.clickable(enabled = isClickable, onClick = onClick)
    )
}

@Composable
private fun CenterText(isVisible: Boolean) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn() + expandIn(),
            exit = fadeOut() + shrinkOut()
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "HAHAHAHAHAHHAHAHA",
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}