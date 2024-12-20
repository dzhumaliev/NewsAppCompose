package com.kg.newsappcompose.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kg.newsappcompose.data.network.remote.Api
import com.kg.newsappcompose.domain.base.Failure
import com.kg.newsappcompose.domain.news.Articles
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class NewsPagingSource @AssistedInject constructor(
    private var api: Api,
    @Assisted("q") private val q: String
) :
    PagingSource<Int, Articles>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Articles> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = api.getNews(q, position, PAGE_SIZE).let {
                NewsMapper().mapLeftToRight(it)
            }

            toLoadResult(response.articles, position)
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException, is SocketTimeoutException -> {
                    LoadResult.Error(
                        Failure.NoInternet(e.message)
                    )
                }
                is TimeoutException -> {
                    LoadResult.Error(
                        Failure.Timeout(e.message)
                    )
                }
                else -> {
                    LoadResult.Error(
                        Failure.Unknown(e.message)
                    )
                }
            }
        }


    }

    override fun getRefreshKey(state: PagingState<Int, Articles>): Int? = state.anchorPosition

    private fun toLoadResult(
        response: List<Articles>,
        position: Int
    ): LoadResult<Int, Articles> {
        return LoadResult.Page(
            data = response,
            prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
            nextKey = if (response.isEmpty()) null else position + 1,
            itemsBefore = LoadResult.Page.COUNT_UNDEFINED,
            itemsAfter = LoadResult.Page.COUNT_UNDEFINED   //read
        )
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("q") q: String): NewsPagingSource
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
        private const val PAGE_SIZE = 20
    }

}