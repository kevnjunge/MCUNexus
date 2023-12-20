package com.droidsmith.mcunexus.data.network.allEventsResponse

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)