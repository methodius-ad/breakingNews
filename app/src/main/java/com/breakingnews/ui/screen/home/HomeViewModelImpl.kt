package com.breakingnews.ui.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.breakingnews.data.util.DataResult
import com.breakingnews.domain.model.Article
import com.breakingnews.domain.usecase.getarticles.GetArticlesUseCase
import com.breakingnews.domain.usecase.getarticles.GetArticlesUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getArticlesUseCase: GetArticlesUseCase
) : HomeViewModel() {

    override val articlesDataFlow = MutableStateFlow<List<Article>>(emptyList())

    init {
        fetchNewsData()
    }

    override fun fetchNewsData() {
        viewModelScope.launch {
            val result = getArticlesUseCase()
            if (result is DataResult.Success) {
                articlesDataFlow.value = result.data
                Log.d("###", "articles result is Success -> ${result.data}")
            }
        }
    }
}