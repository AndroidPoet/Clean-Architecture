package com.androidpoet.cleanarchitecture.utils

sealed class Resource<T>(val data: T? = null, val exception: Exceptions? = null) {
    class Success<T>(data: T? = null) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(exception: Exceptions? = null, data: T? = null) : Resource<T>(data, exception)
}