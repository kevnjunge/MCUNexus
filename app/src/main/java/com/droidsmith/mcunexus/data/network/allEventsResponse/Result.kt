package com.droidsmith.mcunexus.data.network.allEventsResponse

import com.droidsmith.mcunexus.domain.model.Events

data class Result(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val end: String,
    val id: Int,
    val modified: String,
    val next: Next,
    val previous: Previous,
    val resourceURI: String,
    val series: Series,
    val start: String,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val title: String,
    val urls: List<Url>
){
    fun toEvent():Events{
        return Events(
            id = id,
            title = title,
            description = description.orEmpty(),
            startDate = start,
            endDate = end,
            thumbnail = thumbnail.path,
            thumbnailExt = thumbnail.extension
        )
    }
}