package com.droidsmith.mcunexus.data.network.allSeriesResponse

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)