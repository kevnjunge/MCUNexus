package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class CharactersDTO(
    @SerialName("attributionHTML")
    val attributionHTML: String,
    @SerialName("attributionText")
    val attributionText: String,
    @SerialName("code")
    val code: Int,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("data")
    val `data`: Data,
    @SerialName("etag")
    val etag: String,
    @SerialName("status")
    val status: String
)