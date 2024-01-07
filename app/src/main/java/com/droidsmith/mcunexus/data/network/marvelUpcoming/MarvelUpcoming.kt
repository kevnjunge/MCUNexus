package com.droidsmith.mcunexus.data.network.marvelUpcoming

import com.droidsmith.mcunexus.domain.model.MarvelUpcoming

data class MarvelUpcoming(
    val days_until: Int,
    val following_production: FollowingProduction,
    val id: Int,
    val overview: String,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val type: String
) {
    fun toUpcoming(): MarvelUpcoming {
        return MarvelUpcoming(
            id = id,
            days_until = days_until,
            overview = overview,
            poster_url = poster_url,
            release_date = release_date,
            title = title
        )
    }
}