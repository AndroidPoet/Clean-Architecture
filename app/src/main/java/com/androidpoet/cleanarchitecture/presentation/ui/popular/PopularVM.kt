package com.androidpoet.cleanarchitecture.presentation.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidpoet.cleanarchitecture.domain.SafeResult
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.domain.usecase.GetNowPlayingUseCase
import com.androidpoet.cleanarchitecture.domain.usecase.GetPopularUseCase
import com.androidpoet.cleanarchitecture.presentation.mapper.UiNowPlayingMapper
import com.androidpoet.cleanarchitecture.presentation.model.UiLayerNowPlaying
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject



@HiltViewModel
class PopularVM @Inject constructor(
    private val getPopularUseCase: GetPopularUseCase,
    private val uiNowPlayingMapper: UiNowPlayingMapper
) : ViewModel() {

    var viewState = MutableStateFlow<PopularViewState>(PopularViewState.Loading)
        private set


    init {
        getCoins()
    }


    private fun getCoins() {
        viewState.value = PopularViewState.Loading
        viewModelScope.launch {
            val result = getPopularUseCase.perform()
//            Log.d("result", result.toString())
            when (result) {


                is SafeResult.Success -> {
                    val jokes = uiNowPlaying(result)
                    viewState.value = PopularViewState.ShowPopular(jokes)
                }
                is SafeResult.Failure -> {
                    viewState.value = PopularViewState.Error(result.message)
                }
                SafeResult.NetworkError -> {
                    viewState.value = PopularViewState.Error("Network Error")
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

sealed class PopularViewState {
    object Loading : PopularViewState()
    class ShowPopular(var nowPlayings: List<UiLayerNowPlaying.NowPlaying>) : PopularViewState()
    class Error(var message: String) : PopularViewState()
}

