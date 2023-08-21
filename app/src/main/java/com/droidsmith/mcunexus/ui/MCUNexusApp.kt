package com.droidsmith.mcunexus.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.droidsmith.mcunexus.ui.screens.HomeScreen

@Composable
fun MCUNexusApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        HomeScreen()


    }
}