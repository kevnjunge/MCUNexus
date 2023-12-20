package com.droidsmith.mcunexus.data.network.allSeriesResponse

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)