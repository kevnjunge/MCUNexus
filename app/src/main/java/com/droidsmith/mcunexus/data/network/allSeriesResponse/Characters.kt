package com.droidsmith.mcunexus.data.network.allSeriesResponse

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)