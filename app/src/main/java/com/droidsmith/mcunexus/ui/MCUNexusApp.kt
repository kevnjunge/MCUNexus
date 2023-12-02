package com.droidsmith.mcunexus.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.droidsmith.mcunexus.ui.screens.SetupNavGraph
import com.droidsmith.mcunexus.ui.screens.characters.CharactersViewModel

@Composable
fun MCUNexusApp(
    navController: NavHostController = rememberNavController()
) {
    // Use hiltViewModel to get an instance of CharactersViewModel
    val charactersViewModel: CharactersViewModel = hiltViewModel()

    // Observe characters list state and re-render the UI when it changes
    val mcuListState by charactersViewModel.mcuValue.collectAsState()

    // Surface content
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        // Check if charactersList is not null before passing it to SetupNavGraph
        mcuListState.characterList?.let {
            SetupNavGraph(navController = navController, charactersList = it)
        }
    }

    // Trigger the API call to fetch characters when the app starts
    LaunchedEffect(key1 = charactersViewModel) {
        charactersViewModel.getAllCharactersData(offset = 0)
    }
}