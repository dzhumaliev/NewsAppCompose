package com.kg.newsappcompose.app.di.modules

import com.kg.newsappcompose.data.network.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Provides
    @Singleton
    fun api(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}