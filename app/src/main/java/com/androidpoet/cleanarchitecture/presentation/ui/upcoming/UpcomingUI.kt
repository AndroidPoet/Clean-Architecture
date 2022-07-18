package com.androidpoet.cleanarchitecture.presentation.ui.upcoming

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.androidpoet.cleanarchitecture.commonui.material.MovieItem
import com.androidpoet.cleanarchitecture.navigator.ComposeNavigator
import com.androidpoet.cleanarchitecture.presentation.ui.nowPlaying.NowPlayingViewState


@Composable
fun UpcomingUI(
    composeNavigator: ComposeNavigator,
    viewModel: UpcomingVM = hiltViewModel()
) {

    val state = viewModel.viewState.collectAsState()

    Box(
        Modifier.fillMaxSize()
    ) {
        when (state.value) {

            is UpComingViewState.Loading -> {
                CircularProgressIndicator(
                    Modifier.align(Alignment.Center)
                )
            }

            is UpComingViewState.ShowUpComing -> {

                LazyColumn(
                    Modifier.fillMaxSize()
                ) {
                    val coins = (state.value as UpComingViewState.ShowUpComing).nowPlayings
                    items(coins) { nowPlaying ->
                        MovieItem(
                            uiLayerNowPlaying = nowPlaying,
                            onItemClick = viewModel::navigateToDetail
                        )
                    }
                }
            }

            is UpComingViewState.Error -> {
                val message = (state.value as NowPlayingViewState.Error).message
                Text(text = message)

            }
        }

    }
}