package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class Item(
    @SerialName("name")
    val name: String,
    @SerialName("resourceURI")
    val resourceURI: String
)