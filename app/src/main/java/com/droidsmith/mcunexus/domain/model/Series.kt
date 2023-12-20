package com.droidsmith.mcunexus.domain.model

data class Series(
    val id: Int,
    val title: String,
    val description: String,
    val startYear: Int,
    val endYear: Int,
    val thumbnail: String,
    val thumbnailExt: String
)
