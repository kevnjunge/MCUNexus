package com.droidsmith.mcunexus.data.network.allStoriesResponse

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)