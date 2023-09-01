package com.droidsmith.mcunexus.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droidsmith.mcunexus.ui.screens.characterDetail.CharacterDetailScreen
import com.droidsmith.mcunexus.ui.screens.characters.CharactersScreen
import com.droidsmith.mcunexus.ui.screens.characters.CharactersViewModel
import com.droidsmith.mcunexus.ui.screens.comics.ComicsScreen
import com.droidsmith.mcunexus.ui.screens.creators.CreatorsScreen
import com.droidsmith.mcunexus.ui.screens.events.EventsScreen
import com.droidsmith.mcunexus.ui.screens.home.HomeScreen
import com.droidsmith.mcunexus.ui.screens.series.SeriesScreen
import com.droidsmith.mcunexus.ui.screens.stories.StoriesScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Character.route
        ) {
            val viewModel: CharactersViewModel = viewModel()
            CharactersScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                viewModel = viewModel,
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.CharacterDetail.route
        ) {
            CharacterDetailScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.Comics.route
        ) {
            ComicsScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.Creators.route
        ) {
            CreatorsScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.Events.route
        ) {
            EventsScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.Series.route
        ) {
            SeriesScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = Screen.Stories.route
        ) {
            StoriesScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    }
}