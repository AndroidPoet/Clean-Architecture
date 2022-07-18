package com.androidpoet.cleanarchitecture.data.remote.nowPlaying


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class NowPlayingRoot(
    @Json(name = "dates")
    val dates: Dates = Dates(),
    @Json(name = "page")
    val page: Int = 0,
    @Json(name = "results")
    val nowPlayings: List<NowPlaying> = listOf(),
    @Json(name = "total_pages")
    val totalPages: Int = 0,
    @Json(name = "total_results")
    val totalResults: Int = 0
) : Parcelable