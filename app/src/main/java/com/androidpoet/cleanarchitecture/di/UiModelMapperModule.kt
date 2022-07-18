package com.androidpoet.cleanarchitecture.di


import com.androidpoet.cleanarchitecture.domain.mappers.UiModelMapper
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.presentation.mapper.UiNowPlayingMapper
import com.androidpoet.cleanarchitecture.presentation.model.UiLayerNowPlaying
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UiModelMapperModule {


    @Binds
    @Singleton
    abstract fun bindUINowPlayingMapper(nowPlayingMapper: UiNowPlayingMapper): UiModelMapper<DomainLayerMovies.Movie, UiLayerNowPlaying.NowPlaying>

}