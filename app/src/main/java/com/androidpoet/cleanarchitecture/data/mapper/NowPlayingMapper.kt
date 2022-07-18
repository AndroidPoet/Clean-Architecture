package com.androidpoet.cleanarchitecture.data.mapper

import com.androidpoet.cleanarchitecture.data.remote.nowPlaying.NowPlaying
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import javax.inject.Inject


class NowPlayingMapper @Inject constructor() :
    EntityMapper<DomainLayerMovies.Movie, NowPlaying> {
    override fun mapToDomain(entity: NowPlaying): DomainLayerMovies.Movie {
        return DomainLayerMovies.Movie(
            adult = entity.adult,
            backdropPath = entity.backdropPath,
            genreIds = entity.genreIds,
            id = entity.id,
            originalLanguage = entity.originalLanguage,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            title = entity.title,
            video = entity.video,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount

        )

    }

    override fun mapToData(model: DomainLayerMovies.Movie): NowPlaying {
        TODO("Not yet implemented")
    }

}