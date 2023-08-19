package com.droidsmith.mcunexus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.droidsmith.mcunexus.ui.screens.CharactersScreen
import com.droidsmith.mcunexus.ui.screens.HomeScreen
import com.droidsmith.mcunexus.ui.theme.MarvelRed

@Composable
fun MCUNexusApp() {
    Surface(
        color = MarvelRed,
        modifier = Modifier
            .fillMaxSize()

    ) {
        //HomeScreen()
        CharactersScreen()

    }
}