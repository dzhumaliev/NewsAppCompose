package com.kg.newsappcompose.app.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

//    @Provides
//    @ViewModelScoped
//    fun newsRepo(
//        pagingSource: NewsPagingSource.Factory,
//        q: String
//    ): NewsRepository = NewsRepositoryImpl(pagingSource)

//    @Provides
//    fun provideNewsUseCase(repository: NewsRepositoryImpl) : NewsUseCase{
//        return NewsUseCase(repository)
//    }

}