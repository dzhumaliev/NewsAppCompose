package com.kg.newsappcompose.data.network.remote

import com.kg.newsappcompose.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("everything")
    suspend fun getNews(
        @Query("q") q: String = "tesla",
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsModel
}