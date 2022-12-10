package com.breakingnews.ui.screen.info

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class InfoViewModel : ViewModel() {

    abstract val homeScreenLastTime: Int?
    abstract val timeFlow: StateFlow<Int>
}