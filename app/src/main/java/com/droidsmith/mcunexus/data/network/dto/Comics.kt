package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class Comics(
    @SerialName("available")
    val available: Int,
    @SerialName("collectionURI")
    val collectionURI: String,
    @SerialName("items")
    val items: List<Item>,
    @SerialName("items")
    val returned: Int
)