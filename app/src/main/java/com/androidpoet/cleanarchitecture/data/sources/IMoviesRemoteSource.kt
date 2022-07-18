package com.androidpoet.cleanarchitecture.data.sources

import com.androidpoet.cleanarchitecture.data.remote.adapter.NetworkResult
import com.androidpoet.cleanarchitecture.data.remote.nowPlaying.NowPlayingRoot


interface IMoviesRemoteSource {
    suspend fun getNowPlayingList(): NetworkResult<NowPlayingRoot>

    suspend fun getPopularList(): NetworkResult<NowPlayingRoot>

    suspend fun getTopRatedList(): NetworkResult<NowPlayingRoot>

    suspend fun getUpcomingList(): NetworkResult<NowPlayingRoot>

}
