package com.androidpoet.cleanarchitecture.data.sources

import com.androidpoet.cleanarchitecture.data.remote.MoviesApiService
import com.androidpoet.cleanarchitecture.data.remote.adapter.NetworkResult
import com.androidpoet.cleanarchitecture.data.remote.nowPlaying.NowPlayingRoot
import com.androidpoet.cleanarchitecture.di.dispatcher.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MoviesRemoteSource @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val coroutineMainDispatcherProvider: CoroutineDispatcherProvider
) : IMoviesRemoteSource {


    override suspend fun getNowPlayingList(): NetworkResult<NowPlayingRoot> {
        return withContext(coroutineMainDispatcherProvider.io) {
            moviesApiService.getNowPlayingList()
        }
    }

    override suspend fun getPopularList(): NetworkResult<NowPlayingRoot> {
        return withContext(coroutineMainDispatcherProvider.io) {
            moviesApiService.getPopularList()
        }
    }

    override suspend fun getTopRatedList(): NetworkResult<NowPlayingRoot> {
        return withContext(coroutineMainDispatcherProvider.io) {
            moviesApiService.getTopRatedList()
        }
    }

    override suspend fun getUpcomingList(): NetworkResult<NowPlayingRoot> {
        return withContext(coroutineMainDispatcherProvider.io) {
            moviesApiService.getUpcomingList()
        }
    }


}