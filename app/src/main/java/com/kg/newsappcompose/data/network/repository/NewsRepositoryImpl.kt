package com.kg.newsappcompose.data.network.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kg.newsappcompose.data.network.NewsPagingSource
import com.kg.newsappcompose.domain.news.Articles
import com.kg.newsappcompose.domain.news.repository.NewsRepository
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@BoundTo(supertype = NewsRepository::class, component = SingletonComponent::class)
class NewsRepositoryImpl @Inject constructor(
    private val pagingSourceFactory: NewsPagingSource.Factory
) : NewsRepository {

    override fun getNews(q: String): Flow<PagingData<Articles>> =
        Pager(config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false,
            prefetchDistance = 3
        ),
            pagingSourceFactory = { pagingSourceFactory.create(q) }
        ).flow
}