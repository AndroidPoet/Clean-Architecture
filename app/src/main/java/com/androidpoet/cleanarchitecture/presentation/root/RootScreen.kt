package com.androidpoet.cleanarchitecture.presentation.root

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.androidpoet.cleanarchitecture.commonui.material.SlackSurfaceAppBar
import com.androidpoet.cleanarchitecture.navigator.ComposeNavigator
import com.androidpoet.cleanarchitecture.presentation.ui.nowPlaying.NowPlayingUi
import com.androidpoet.cleanarchitecture.presentation.ui.popular.PopularUi
import com.androidpoet.cleanarchitecture.presentation.ui.topRated.TopRatedUi
import com.androidpoet.cleanarchitecture.presentation.ui.upcoming.UpcomingUI
import com.androidpoet.cleanarchitecture.ui.theme.SlackCloneColorProvider
import com.androidpoet.cleanarchitecture.ui.theme.SlackCloneSurface
import com.androidpoet.cleanarchitecture.ui.theme.SlackCloneTheme
import com.androidpoet.cleanarchitecture.ui.theme.SlackCloneTypography



@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootScreen(
    composeNavigator: ComposeNavigator,
) {
    val scaffoldState = rememberScaffoldState()
    val dashboardNavController = rememberNavController()

    SlackCloneTheme {
        DashboardScaffold(scaffoldState, dashboardNavController, composeNavigator)
    }


}


@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DashboardScaffold(
    scaffoldState: ScaffoldState,
    dashboardNavController: NavHostController,
    composeNavigator: ComposeNavigator,
) {
    Box() {
        Scaffold(

            backgroundColor = SlackCloneColorProvider.colors.uiBackground,
            contentColor = SlackCloneColorProvider.colors.textSecondary,
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding(),
            scaffoldState = scaffoldState,
            topBar = { TopAppBar() },
            bottomBar = {
                DashboardBottomNavBar(dashboardNavController)
            },
            snackbarHost = {
                scaffoldState.snackbarHostState
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                SlackCloneSurface(
                    color = SlackCloneColorProvider.colors.uiBackground,
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        dashboardNavController,
                        startDestination = Screen.NowPlaying.route,
                    ) {
                        composable(Screen.NowPlaying.route
                        ) {
                            NowPlayingUi(composeNavigator)
                        }
                        composable(Screen.Popular.route) {

                            PopularUi(composeNavigator = composeNavigator)
                        }
                        composable(Screen.Upcoming.route) {
                            UpcomingUI(composeNavigator = composeNavigator)
                        }
                        composable(Screen.TopRated.route) {
                            TopRatedUi(composeNavigator = composeNavigator)
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun DashboardBottomNavBar(navController: NavHostController) {
    Column(Modifier.background(color = SlackCloneColorProvider.colors.uiBackground)) {
        Divider(
            color = SlackCloneColorProvider.colors.textPrimary.copy(alpha = 0.2f),
            thickness = 0.5.dp
        )
        BottomNavigation(backgroundColor = SlackCloneColorProvider.colors.uiBackground) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val dashTabs = getDashTabs()
            dashTabs.forEach { screen ->
                BottomNavItem(screen, currentDestination, navController)
            }
        }
    }
}

@Composable
private fun RowScope.BottomNavItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {

    BottomNavigationItem(
        selectedContentColor = SlackCloneColorProvider.colors.bottomNavSelectedColor,
        unselectedContentColor = SlackCloneColorProvider.colors.bottomNavUnSelectedColor,
        icon = { Icon(painterResource(id = screen.image), contentDescription = screen.route) },
        label = {
            Text(
                stringResource(screen.resourceId),
                maxLines = 1,
                style = SlackCloneTypography.overline,
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navigateTab(navController, screen)
        }
    )
}

private fun navigateTab(
    navController: NavHostController,
    screen: Screen
) {
    navController.navigate(screen.route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}

private fun getDashTabs(): MutableList<Screen> {
    return mutableListOf<Screen>().apply {
        add(Screen.NowPlaying)
        add(Screen.Popular)
        add(Screen.TopRated)
        add(Screen.Upcoming)
    }


}

@Composable
private fun TopAppBar() {
    SlackSurfaceAppBar(
        title = {
            Text(text = "Movies App", style = SlackCloneTypography.h5.copy(color = Color.White))
        },
        backgroundColor = SlackCloneColorProvider.colors.appBarColor,
    )
}
