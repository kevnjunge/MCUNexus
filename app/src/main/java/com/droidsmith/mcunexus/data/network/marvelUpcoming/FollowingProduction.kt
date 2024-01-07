package com.droidsmith.mcunexus.data.network.marvelUpcoming

data class FollowingProduction(
    val days_until: Int,
    val id: Int,
    val overview: String,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val type: String
)