package com.kg.newsappcompose.app.di.modules

import com.kg.newsappcompose.data.network.createNetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun retrofit(): Retrofit = createNetworkClient()
}