package com.droidsmith.mcunexus.data.network.allEventsResponse

data class Events(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)