package com.breakingnews.ui.screen.menu

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class MenuViewModel : ViewModel() {

    abstract val userDataFlow: StateFlow<List<String>>
}