package com.androidpoet.cleanarchitecture.data.repository

import com.androidpoet.cleanarchitecture.data.mapper.EntityMapper
import com.androidpoet.cleanarchitecture.data.remote.adapter.NetworkResult
import com.androidpoet.cleanarchitecture.data.remote.nowPlaying.NowPlaying
import com.androidpoet.cleanarchitecture.data.sources.MoviesRemoteSource
import com.androidpoet.cleanarchitecture.domain.SafeResult
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.domain.repository.IMoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteSource: MoviesRemoteSource,
    private val movieMapper: EntityMapper<DomainLayerMovies.Movie, NowPlaying>,
) : IMoviesRepository {
    override suspend fun getNowPlayingList(): SafeResult<List<DomainLayerMovies.Movie>> {
        remoteSource.getNowPlayingList().run {
            return when (this) {
                is NetworkResult.Success -> SafeResult.Success((this.data).nowPlayings.map { movie ->
                    movieMapper.mapToDomain(
                        movie
                    )
                })
                is NetworkResult.Error -> SafeResult.NetworkError
                is NetworkResult.Exception -> SafeResult.Failure(
                    this.e,
                    this.e.localizedMessage
                )
            }

        }


    }


    override suspend fun getPopularList(): SafeResult<List<DomainLayerMovies.Movie>> {
        remoteSource.getPopularList().run {
            return when (this) {
                is NetworkResult.Success -> SafeResult.Success((this.data).nowPlayings.map { movie ->
                    movieMapper.mapToDomain(
                        movie
                    )
                })
                is NetworkResult.Error -> SafeResult.NetworkError
                is NetworkResult.Exception -> SafeResult.Failure(
                    this.e,
                    this.e.localizedMessage
                )
            }

        }
    }

    override suspend fun getTopRatedList(): SafeResult<List<DomainLayerMovies.Movie>> {
        remoteSource.getTopRatedList().run {
            return when (this) {
                is NetworkResult.Success -> SafeResult.Success((this.data).nowPlayings.map { movie ->
                    movieMapper.mapToDomain(
                        movie
                    )
                })
                is NetworkResult.Error -> SafeResult.NetworkError
                is NetworkResult.Exception -> SafeResult.Failure(
                    this.e,
                    this.e.localizedMessage
                )
            }

        }
    }

    override suspend fun getUpcomingList(): SafeResult<List<DomainLayerMovies.Movie>> {
        remoteSource.getUpcomingList().run {
            return when (this) {
                is NetworkResult.Success -> SafeResult.Success((this.data).nowPlayings.map { movie ->
                    movieMapper.mapToDomain(
                        movie
                    )
                })
                is NetworkResult.Error -> SafeResult.NetworkError
                is NetworkResult.Exception -> SafeResult.Failure(
                    this.e,
                    this.e.localizedMessage
                )
            }

        }
    }


}