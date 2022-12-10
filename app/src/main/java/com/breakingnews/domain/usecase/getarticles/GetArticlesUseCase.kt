package com.breakingnews.domain.usecase.getarticles

import com.breakingnews.data.util.DataResult
import com.breakingnews.domain.model.Article

interface GetArticlesUseCase {
    suspend operator fun invoke(): DataResult<List<Article>>
}