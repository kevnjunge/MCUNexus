package com.droidsmith.mcunexus.data.network.allStoriesResponse

import com.droidsmith.mcunexus.domain.model.Stories

data class Result(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val originalIssue: OriginalIssue,
    val resourceURI: String,
    val series: Series,
    val thumbnail: Any,
    val title: String,
    val type: String
){
    fun toStories():Stories{
        return Stories(
            id = id,
            title = title,
            description = description.orEmpty()
        )
    }
}