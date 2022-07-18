package com.androidpoet.cleanarchitecture.presentation.model

interface UiLayerNowPlaying {

    data class NowPlaying(
        val adult: Boolean = false,
        val backdropPath: String = "",
        val genreIds: List<Int> = emptyList(),
        val id: Int = 0,
        val originalLanguage: String = "",
        val originalTitle: String = "",
        val overview: String = "",
        val popularity: Double = 0.0,
        val posterPath: String = "",
        val releaseDate: String = "",
        val title: String = "",
        val video: Boolean = false,
        val voteAverage: Double = 0.0,
        val voteCount: Int = 0

    )
}