package com.androidpoet.cleanarchitecture.presentation.ui.nowPlaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidpoet.cleanarchitecture.domain.SafeResult
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.domain.usecase.GetNowPlayingUseCase
import com.androidpoet.cleanarchitecture.presentation.mapper.UiNowPlayingMapper
import com.androidpoet.cleanarchitecture.presentation.model.UiLayerNowPlaying
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NowPlayingVM @Inject constructor(
    private val getNowPlayingUseCase: GetNowPlayingUseCase,
    private val uiNowPlayingMapper: UiNowPlayingMapper
) : ViewModel() {

    var viewState = MutableStateFlow<NowPlayingViewState>(NowPlayingViewState.Loading)
        private set


    init {
        getCoins()
    }


    private fun getCoins() {
        viewState.value = NowPlayingViewState.Loading
        viewModelScope.launch {
            val result = getNowPlayingUseCase.perform()
//            Log.d("result", result.toString())
            when (result) {


                is SafeResult.Success -> {
                    val jokes = uiNowPlaying(result)
                    viewState.value = NowPlayingViewState.ShowNowPlaying(jokes)
                }
                is SafeResult.Failure -> {
                    viewState.value = NowPlayingViewState.Error(result.message)
                }
                SafeResult.NetworkError -> {
                    viewState.value = NowPlayingViewState.Error("Network Error")
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

sealed class NowPlayingViewState {
    object Loading : NowPlayingViewState()
    class ShowNowPlaying(var nowPlayings: List<UiLayerNowPlaying.NowPlaying>) : NowPlayingViewState()
    class Error(var message: String) : NowPlayingViewState()
}
