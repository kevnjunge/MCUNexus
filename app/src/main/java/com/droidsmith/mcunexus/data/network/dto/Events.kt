package com.droidsmith.mcunexus.data.network.dto

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)