package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class Thumbnail(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
)