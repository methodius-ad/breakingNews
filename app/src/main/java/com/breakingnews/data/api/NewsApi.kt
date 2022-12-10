package com.breakingnews.data.api

import com.breakingnews.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NewsApi {
//    Your API key is: 3237fc7580f740118918b65fe5794390
    @GET("everything")
    // TODO: change, add logic to filter articles by category, by date and variants of sorting
    // TODO: move api key to interceptor
    suspend fun getNews(
        @Query("q") category: String = "tesla",
        @Query("from") articlesByDate: String = "2022-11-10",
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = "3237fc7580f740118918b65fe5794390"
    ): NewsResponse
}