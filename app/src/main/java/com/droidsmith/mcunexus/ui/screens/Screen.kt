package com.droidsmith.mcunexus.ui.screens

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Character : Screen(route = "character_screen")
    object CharacterDetail : Screen(route = "character_detail_screen ")
    object Comics: Screen(route = "comics_screen")
    object Creators: Screen(route = "creators_screen")
    object Events:Screen(route = "events_screen")
    object Series : Screen(route = "series_screen")
    object Stories: Screen(route = "stories_screen")
}
