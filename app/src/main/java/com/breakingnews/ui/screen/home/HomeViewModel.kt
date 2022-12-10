package com.breakingnews.ui.screen.home

import androidx.lifecycle.ViewModel
import com.breakingnews.domain.model.Article
import kotlinx.coroutines.flow.StateFlow

abstract class HomeViewModel : ViewModel() {

    abstract val articlesDataFlow: StateFlow<List<Article>>

    abstract fun fetchNewsData()
}