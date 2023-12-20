package com.droidsmith.mcunexus.domain.model

data class Comic(
    val id: Int,
    val title: String,
    val issueNumber: Int,
    val description: String,
    val pageCount: Int,
    val thumbnail: String,
    val thumbnailExt: String,
)
