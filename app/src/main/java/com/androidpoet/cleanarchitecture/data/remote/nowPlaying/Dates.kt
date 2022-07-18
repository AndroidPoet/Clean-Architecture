package com.androidpoet.cleanarchitecture.data.remote.nowPlaying


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Dates(
    @Json(name = "maximum")
    val maximum: String = "",
    @Json(name = "minimum")
    val minimum: String = ""
) : Parcelable