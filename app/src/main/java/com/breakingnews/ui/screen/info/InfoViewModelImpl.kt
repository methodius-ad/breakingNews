package com.breakingnews.ui.screen.info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.breakingnews.ui.navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class InfoViewModelImpl(savedStateHandle: SavedStateHandle) : InfoViewModel() {

    override val homeScreenLastTime: Int? = savedStateHandle[Screen.Info.HOME_SCREEN_LAST_TIME_KEY]
    override val timeFlow = MutableStateFlow(0)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (isActive) {
                timeFlow.emit(timeFlow.value.inc())
                delay(1000L)
            }
        }
    }
}