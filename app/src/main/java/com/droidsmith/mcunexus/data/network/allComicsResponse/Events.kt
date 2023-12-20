package com.droidsmith.mcunexus.data.network.allComicsResponse

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)