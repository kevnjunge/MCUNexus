package com.droidsmith.mcunexus.domain.model

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val thumbnailExt: String,
    val comics: List<String>
)
