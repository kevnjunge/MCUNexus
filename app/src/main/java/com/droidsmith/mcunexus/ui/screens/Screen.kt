package com.droidsmith.mcunexus.ui.screens

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Character : Screen(route = "character_screen")
    object CharacterDetail : Screen(route = "character_detail_screen ")
}
