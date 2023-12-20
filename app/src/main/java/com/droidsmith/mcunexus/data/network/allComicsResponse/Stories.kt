package com.droidsmith.mcunexus.data.network.allComicsResponse

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)