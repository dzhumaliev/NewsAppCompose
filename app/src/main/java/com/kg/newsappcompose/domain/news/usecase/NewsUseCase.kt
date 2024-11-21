package com.kg.newsappcompose.domain.news.usecase

import androidx.paging.PagingData
import com.kg.newsappcompose.domain.news.repository.NewsRepository
import com.kg.newsappcompose.model.Articles
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@BoundTo(supertype = NewsRepository::class, component = SingletonComponent::class)
class NewsUseCase @Inject constructor(private val newsRepo: NewsRepository) {

    operator fun invoke(q: String): Flow<PagingData<Articles>> = newsRepo.getNews(q)

}