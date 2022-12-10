package com.breakingnews.domain.model

import com.squareup.moshi.Json

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String,
    val publishedAt: String
)
