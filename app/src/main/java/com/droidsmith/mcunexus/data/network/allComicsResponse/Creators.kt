package com.droidsmith.mcunexus.data.network.allComicsResponse

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)