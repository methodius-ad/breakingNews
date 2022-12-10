package com.breakingnews.data.mapper

import com.breakingnews.data.model.ArticleResponse
import com.breakingnews.data.model.NewsResponse
import com.breakingnews.domain.model.Article

class NewsResponseToArticlesMapper : (NewsResponse) -> List<Article> {
    override fun invoke(response: NewsResponse): List<Article> {
        return response.articles.map { articleResponse ->
            Article(
                author = articleResponse.author ?: "",
                title = articleResponse.title ?: "",
                description = articleResponse.description ?: "",
                url = articleResponse.url ?: "",
                imageUrl = articleResponse.imageUrl ?: "",
                publishedAt = articleResponse.publishedAt ?: ""
            )
        }
    }
}