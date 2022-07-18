package com.androidpoet.cleanarchitecture.utils

sealed class Exceptions(val message: String? = null) {
    class Unexpected(message: String? = "An unexpected error. Try again.") : Exceptions(message)
    class Server(message: String? = "Couldn't reach server. Check your internet connection and try again.") : Exceptions(message)
    class Cache(message: String? = "An unexpected error trying to access cache data. Try again.") : Exceptions(message)
}