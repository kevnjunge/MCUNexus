package com.droidsmith.mcunexus.data.network.allStoriesResponse

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)