package com.droidsmith.mcunexus.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.droidsmith.mcunexus.ui.screens.characterDetail.CharacterDetailScreen
import com.droidsmith.mcunexus.ui.screens.characters.CharactersScreen
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
            CharactersScreen(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                navController = navController
            )
        }
        composable(
            route = Screen.CharacterDetail.route,
            arguments = listOf(navArgument(CHARACTER_DETAIL_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ) {
            Log.d("Args",it.arguments?.getInt(CHARACTER_DETAIL_ARGUMENT_KEY).toString())
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