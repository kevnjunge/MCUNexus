package com.droidsmith.mcunexus.data.network.dto

import kotlinx.serialization.SerialName

data class Data(
    @SerialName("count")
    val count: Int,
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("results")
    val results: List<Result>,
    @SerialName("total")
    val total: Int
)