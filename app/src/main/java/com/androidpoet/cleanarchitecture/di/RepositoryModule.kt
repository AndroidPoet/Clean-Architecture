package com.androidpoet.cleanarchitecture.di

import com.androidpoet.cleanarchitecture.data.repository.MoviesRepositoryImpl
import com.androidpoet.cleanarchitecture.domain.repository.IMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCoinRepository(moviesRepositoryImpl: MoviesRepositoryImpl): IMoviesRepository


}