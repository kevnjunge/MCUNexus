package com.droidsmith.mcunexus.domain.model

data class MarvelUpcoming(
    val id: Int,
    val days_until: Int,
    val overview: String,
    val poster_url: String,
    val release_date: String,
    val title: String
)