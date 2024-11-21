package com.kg.newsappcompose.domain.news.repository

import androidx.paging.PagingData
import com.kg.newsappcompose.model.Articles
import kotlinx.coroutines.flow.Flow

interface NewsRepository  {
    fun getNews(q: String): Flow<PagingData<Articles>>
}