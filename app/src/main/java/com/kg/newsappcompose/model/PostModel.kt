package com.kg.newsappcompose.model

data class PostModel(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles> = emptyList()
)

data class Articles(
    val source: Source,
    val author: String? = null,
    val description: String? = null,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String? = null
)

data class Source(
    val name: String
)