package com.androidpoet.cleanarchitecture.presentation.mapper

import com.androidpoet.cleanarchitecture.domain.mappers.UiModelMapper
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.presentation.model.UiLayerNowPlaying
import javax.inject.Inject


class UiNowPlayingMapper @Inject constructor() :
    UiModelMapper<DomainLayerMovies.Movie, UiLayerNowPlaying.NowPlaying> {
    override fun mapToPresentation(model: DomainLayerMovies.Movie): UiLayerNowPlaying.NowPlaying {
        return UiLayerNowPlaying.NowPlaying(
            adult = model.adult,
            backdropPath = model.backdropPath,
            genreIds = model.genreIds,
            id = model.id,
            originalLanguage = model.originalLanguage,
            originalTitle = model.originalTitle,
            overview = model.overview,
            popularity = model.popularity,
            posterPath = model.posterPath,
            releaseDate = model.releaseDate,
            title = model.title,
            video = model.video,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )


    }

    override fun mapToDomain(modelItem: UiLayerNowPlaying.NowPlaying): DomainLayerMovies.Movie {
        return DomainLayerMovies.Movie(
            adult = modelItem.adult,
            backdropPath = modelItem.backdropPath,
            genreIds = modelItem.genreIds,
            id = modelItem.id,
            originalLanguage = modelItem.originalLanguage,
            originalTitle = modelItem.originalTitle,
            overview = modelItem.overview,
            popularity = modelItem.popularity,
            posterPath = modelItem.posterPath,
            releaseDate = modelItem.releaseDate,
            title = modelItem.title,
            video = modelItem.video,
            voteAverage = modelItem.voteAverage,
            voteCount = modelItem.voteCount
        )
    }

}
