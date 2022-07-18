package com.androidpoet.cleanarchitecture.navigator

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class MovieScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    // onboarding
    object RootScreen : MovieScreen("RootScreen")
    object SkipTypingScreen : MovieScreen("SkipTypingUI")
    object EmailAddressInputUI : MovieScreen("EmailAddressInputUI")
    object WorkspaceInputUI : MovieScreen("WorkspaceInputUI")

    // dashboard
    object Dashboard : MovieScreen(
        "Dashboard",
        navArguments = listOf(navArgument("channelId") { type = NavType.StringType })
    ) {
        fun createRoute(channelId: String) =
            route.replace("{${navArguments.first().name}}", channelId)
    }

    object CreateChannelsScreen : MovieScreen("CreateChannelsScreen")
    object CreateNewChannel : MovieScreen("CreateNewChannel")
    object CreateNewDM : MovieScreen("CreateNewDM")
    object MoviePreferences : MovieScreen("SlackPreferences")

}

sealed class MoviesRoute(val name: String) {
    object MainScreen : MoviesRoute("mainscreens")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}