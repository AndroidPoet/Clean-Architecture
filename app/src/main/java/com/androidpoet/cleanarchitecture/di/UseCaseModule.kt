package com.androidpoet.cleanarchitecture.di

import com.androidpoet.cleanarchitecture.domain.repository.IMoviesRepository
import com.androidpoet.cleanarchitecture.domain.usecase.GetNowPlayingUseCase
import com.androidpoet.cleanarchitecture.domain.usecase.GetPopularUseCase
import com.androidpoet.cleanarchitecture.domain.usecase.GetTopRatedUseCase
import com.androidpoet.cleanarchitecture.domain.usecase.GetUpcomingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetNowPlayingUseCase(IMoviesRepository: IMoviesRepository) =
        GetNowPlayingUseCase(IMoviesRepository)




    @Provides
    @ViewModelScoped
    fun provideGetPopularUseCase(IMoviesRepository: IMoviesRepository) =
        GetPopularUseCase(IMoviesRepository)



    @Provides
    @ViewModelScoped
    fun provideGetTopRatedUseCase(IMoviesRepository: IMoviesRepository) =
        GetTopRatedUseCase(IMoviesRepository)




    @Provides
    @ViewModelScoped
    fun provideGetUpcomingUseCase(IMoviesRepository: IMoviesRepository) =
        GetUpcomingUseCase(IMoviesRepository)



}