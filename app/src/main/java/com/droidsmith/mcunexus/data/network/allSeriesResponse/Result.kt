package com.droidsmith.mcunexus.data.network.allSeriesResponse

import com.droidsmith.mcunexus.domain.model.Series

data class Result(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val endYear: Int,
    val events: Events,
    val id: Int,
    val modified: String,
    val next: Next,
    val previous: Any,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val title: String,
    val type: String,
    val urls: List<Url>
) {

    fun toSeries(): Series {
        return Series(
            id = id,
            title = title,
            description = description.orEmpty(),
            startYear = startYear,
            endYear = endYear,
            thumbnail = thumbnail.path,
            thumbnailExt = thumbnail.extension
        )
    }

}