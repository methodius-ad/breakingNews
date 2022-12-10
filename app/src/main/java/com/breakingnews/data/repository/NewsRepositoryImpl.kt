package com.breakingnews.data.repository

import com.breakingnews.data.api.NewsApi
import com.breakingnews.data.mapper.NewsResponseToArticlesMapper
import com.breakingnews.data.util.DataResult
import com.breakingnews.data.util.safeApiCall
import com.breakingnews.domain.model.Article

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsResponseToArticlesMapper: NewsResponseToArticlesMapper
) : NewsRepository {

   override suspend fun getNews(): DataResult<List<Article>> {
        return safeApiCall {
            DataResult.Success(
//                newsApi.getNews().execute().body()!!.run(newsResponseToArticlesMapper)
                newsApi.getNews().run(newsResponseToArticlesMapper)
            )
        }
    }
}