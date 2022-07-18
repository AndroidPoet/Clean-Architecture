package com.androidpoet.cleanarchitecture.presentation.ui.upcoming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidpoet.cleanarchitecture.domain.SafeResult
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.domain.usecase.GetNowPlayingUseCase
import com.androidpoet.cleanarchitecture.domain.usecase.GetUpcomingUseCase
import com.androidpoet.cleanarchitecture.presentation.mapper.UiNowPlayingMapper
import com.androidpoet.cleanarchitecture.presentation.model.UiLayerNowPlaying
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class UpcomingVM @Inject constructor(
    private val getUpcomingUseCase: GetUpcomingUseCase,
    private val uiNowPlayingMapper: UiNowPlayingMapper
) : ViewModel() {

    var viewState = MutableStateFlow<UpComingViewState>(UpComingViewState.Loading)
        private set


    init {
        getCoins()
    }


    private fun getCoins() {
        viewState.value = UpComingViewState.Loading
        viewModelScope.launch {
            when (val result = getUpcomingUseCase.perform()) {
                is SafeResult.Success -> {
                    val jokes = uiNowPlaying(result)
                    viewState.value = UpComingViewState.ShowUpComing(jokes)
                }
                is SafeResult.Failure -> {
                    viewState.value = UpComingViewState.Error(result.message)
                }
                SafeResult.NetworkError -> {
                    viewState.value = UpComingViewState.Error("Network Error")
                }
            }
        }
    }

    fun navigateToDetail(uiCoin: UiLayerNowPlaying.NowPlaying) {
        viewModelScope.launch {
            //navigationManager.navigateTo(CoinDetailRoutes.root(uiCoin.id))
        }
    }

    private fun uiNowPlaying(result: SafeResult.Success<List<DomainLayerMovies.Movie>>) =
        result.data.map {

            Timber.d(it.title)

            uiNowPlayingMapper.mapToPresentation(it)
        }


}

sealed class UpComingViewState {
    object Loading : UpComingViewState()
    class ShowUpComing(var nowPlayings: List<UiLayerNowPlaying.NowPlaying>) :
        UpComingViewState()

    class Error(var message: String) : UpComingViewState()
}

