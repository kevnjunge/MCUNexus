package com.droidsmith.mcunexus.ui

import com.droidsmith.mcunexus.domain.model.Character
import com.droidsmith.mcunexus.domain.model.Comic
import com.droidsmith.mcunexus.domain.model.Events
import com.droidsmith.mcunexus.domain.model.Series
import com.droidsmith.mcunexus.domain.model.Stories

data class MCUListState (
    val isLoading : Boolean = false,
    val characterList : List<Character> = emptyList(),
    val comicList : List<Comic> = emptyList(),
    val seriesList: List<Series> = emptyList(),
    val storiesList: List<Stories> = emptyList(),
    val eventsList: List<Events> = emptyList(),
    val error: String = ""
)