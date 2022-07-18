package com.androidpoet.cleanarchitecture.di

import com.androidpoet.cleanarchitecture.data.mapper.EntityMapper
import com.androidpoet.cleanarchitecture.data.mapper.NowPlayingMapper
import com.androidpoet.cleanarchitecture.data.remote.nowPlaying.NowPlaying
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataMappersModule {

    @Binds
    @Singleton
    abstract fun bindNowPlayingMapper(nowPlayingMapper: NowPlayingMapper): EntityMapper<DomainLayerMovies.Movie, NowPlaying>


}