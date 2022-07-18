package com.androidpoet.cleanarchitecture.domain.repository

import com.androidpoet.cleanarchitecture.domain.SafeResult
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies


interface IMoviesRepository {

    suspend fun getNowPlayingList(): SafeResult<List<DomainLayerMovies.Movie>>

    suspend fun getPopularList(): SafeResult<List<DomainLayerMovies.Movie>>

    suspend fun getTopRatedList(): SafeResult<List<DomainLayerMovies.Movie>>

    suspend fun getUpcomingList(): SafeResult<List<DomainLayerMovies.Movie>>
}