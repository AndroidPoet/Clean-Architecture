package com.androidpoet.cleanarchitecture.presentation.root

import androidx.annotation.StringRes
import com.androidpoet.cleanarchitecture.R


sealed class Screen(val route: String, val image: Int, @StringRes val resourceId: Int) {
    object NowPlaying : Screen("Now Playing", R.drawable.ic_baseline_now_playing_24, R.string.now_playing)
    object Popular : Screen("Popular", R.drawable.ic_baseline_popular_24, R.string.popular)
    object TopRated : Screen("Top Rated", R.drawable.ic_baseline_featured_top_rated, R.string.top_rated)
    object Upcoming : Screen("Upcoming", R.drawable.ic_baseline_upcoming_24, R.string.upcoming)


}