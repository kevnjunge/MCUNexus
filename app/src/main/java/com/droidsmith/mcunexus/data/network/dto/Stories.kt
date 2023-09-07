package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class Stories(
    @SerialName("available")
    val available: Int,
    @SerialName("collectionURI")
    val collectionURI: String,
    @SerialName("items")
    val items: List<ItemXXX>,
    @SerialName("returned")
    val returned: Int
)