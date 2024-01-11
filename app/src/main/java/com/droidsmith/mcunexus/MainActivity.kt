package com.droidsmith.mcunexus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.droidsmith.mcunexus.ui.MCUNexusApp
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            //TODO: Find a better way to change the colors so that they adapt to dark and light theme changes

            window.statusBarColor = MarvelRed.toArgb()
            window.navigationBarColor = MarvelRed.toArgb()
            MCUNexusApp()
        }
    }
}



