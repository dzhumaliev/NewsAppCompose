package com.kg.newsappcompose.domain.news



data class News(
    var articles: List<Articles> = listOf()
)

data class Articles(
    var author: String? = null,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var publishedAt: String? = null,
    var content: String? = null
)