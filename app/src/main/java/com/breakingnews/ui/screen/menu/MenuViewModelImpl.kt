package com.breakingnews.ui.screen.menu

import kotlinx.coroutines.flow.MutableStateFlow

class MenuViewModelImpl : MenuViewModel() {

    override val userDataFlow = MutableStateFlow<List<String>>(emptyList())

    init {
        userDataFlow.value =
            listOf(
                "John",
                "jsohncena@gmail.com",
                "35 years old"
            )

    }
}