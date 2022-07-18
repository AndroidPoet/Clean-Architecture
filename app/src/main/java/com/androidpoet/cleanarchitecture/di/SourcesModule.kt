package com.androidpoet.cleanarchitecture.di


import com.androidpoet.cleanarchitecture.data.remote.MoviesApiService
import com.androidpoet.cleanarchitecture.data.sources.MoviesRemoteSource
import com.androidpoet.cleanarchitecture.data.sources.IMoviesRemoteSource
import com.androidpoet.cleanarchitecture.di.dispatcher.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object SourcesModule {

    @Provides
    fun provideCoinListNetworkSource(
        moviesApiService: MoviesApiService,
        coroutineDispatcherProvider: CoroutineDispatcherProvider
    ): IMoviesRemoteSource {
        return MoviesRemoteSource(
            moviesApiService, coroutineDispatcherProvider
        )
    }

}