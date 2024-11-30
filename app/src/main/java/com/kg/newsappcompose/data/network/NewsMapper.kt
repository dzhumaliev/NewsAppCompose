package com.kg.newsappcompose.data.network

import com.kg.newsappcompose.data.network.repository.NewsModel
import com.kg.newsappcompose.domain.base.mapper.Mapper
import com.kg.newsappcompose.domain.news.Articles
import com.kg.newsappcompose.domain.news.News


class NewsMapper : Mapper<NewsModel, News> {
    override fun mapLeftToRight(obj: com.kg.newsappcompose.model.NewsModel): News = with(obj) {
        News(
            articles = articles.map {
                Articles(
                    author = it.author,
                    title = it.title,
                    description = it.description,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt
                )
            }
        )
    }
}