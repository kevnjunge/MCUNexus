package com.droidsmith.mcunexus.ui

import com.droidsmith.mcunexus.domain.model.Character

data class MCUListState (
    val isLoading : Boolean = false,
    val characterList : List<Character> = emptyList(),
    val error: String = ""
)