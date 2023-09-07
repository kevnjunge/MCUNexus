package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class ItemXXX(
    @SerialName("name")
    val name: String,
    @SerialName("resourceURI")
    val resourceURI: String,
    @SerialName("type")
    val type: String
)