package com.breakingnews.domain.usecase.getarticles

import com.breakingnews.data.repository.NewsRepository
import com.breakingnews.data.repository.NewsRepositoryImpl
import com.breakingnews.data.util.DataResult
import com.breakingnews.domain.model.Article

class GetArticlesUseCaseImpl(
    private val newsRepository: NewsRepository
): GetArticlesUseCase {
    override suspend operator fun invoke(): DataResult<List<Article>> {
        return newsRepository.getNews()
    }
}