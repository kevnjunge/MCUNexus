package com.droidsmith.mcunexus.domain.model

data class Events(
    val id: Int,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val thumbnail: String,
    val thumbnailExt: String,
)
