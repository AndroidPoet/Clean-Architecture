package com.androidpoet.cleanarchitecture.domain.usecase


import com.androidpoet.cleanarchitecture.domain.SafeResult
import com.androidpoet.cleanarchitecture.domain.model.DomainLayerMovies
import com.androidpoet.cleanarchitecture.domain.repository.IMoviesRepository
import javax.inject.Inject

class GetTopRatedUseCase @Inject constructor(private val repository: IMoviesRepository) :
    BaseUseCase<SafeResult<List<DomainLayerMovies.Movie>>, Unit> {

    override suspend fun perform(): SafeResult<List<DomainLayerMovies.Movie>> {
        return when (val result = repository.getTopRatedList()) {
            is SafeResult.Success -> SafeResult.Success(result.data)
            is SafeResult.NetworkError -> result
            is SafeResult.Failure -> result
        }
    }

}