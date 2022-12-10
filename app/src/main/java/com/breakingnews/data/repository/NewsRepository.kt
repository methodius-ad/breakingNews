package com.breakingnews.data.repository

import com.breakingnews.data.util.DataResult
import com.breakingnews.domain.model.Article

interface NewsRepository {

    suspend fun getNews(): DataResult<List<Article>>
}