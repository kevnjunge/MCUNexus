package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class Url(
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)