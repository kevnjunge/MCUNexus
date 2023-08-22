package com.droidsmith.mcunexus.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.droidsmith.mcunexus.ui.screens.SetupNavGraph

@Composable
fun MCUNexusApp(
    navController: NavHostController = rememberNavController()
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        SetupNavGraph(navController = navController)


    }
}