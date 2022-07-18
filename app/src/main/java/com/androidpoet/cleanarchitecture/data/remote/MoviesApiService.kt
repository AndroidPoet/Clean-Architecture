package com.androidpoet.cleanarchitecture.data.remote

import com.androidpoet.cleanarchitecture.data.remote.adapter.NetworkResult
import com.androidpoet.cleanarchitecture.data.remote.nowPlaying.NowPlayingRoot
import retrofit2.http.GET

interface MoviesApiService {

    @GET("now_playing")
    suspend fun getNowPlayingList(): NetworkResult<NowPlayingRoot>

    @GET("popular")
    suspend fun getPopularList(): NetworkResult<NowPlayingRoot>


    @GET("top_rated")
    suspend fun getTopRatedList(): NetworkResult<NowPlayingRoot>


    @GET("upcoming")
    suspend fun getUpcomingList(): NetworkResult<NowPlayingRoot>

}