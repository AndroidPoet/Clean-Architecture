package com.androidpoet.cleanarchitecture.presentation.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.androidpoet.cleanarchitecture.navigator.ComposeNavigator
import com.androidpoet.cleanarchitecture.navigator.MovieScreen
import com.androidpoet.cleanarchitecture.navigator.MoviesRoute
import com.androidpoet.cleanarchitecture.presentation.root.RootScreen


fun NavGraphBuilder.moviesNavigation(
    composeNavigator: ComposeNavigator,
) {
    navigation(
        startDestination = MovieScreen.RootScreen.name,
        route = MoviesRoute.MainScreen.name
    ) {
        composable(
            MovieScreen.RootScreen.name
        ) {
            RootScreen(composeNavigator)
        }

    }

}