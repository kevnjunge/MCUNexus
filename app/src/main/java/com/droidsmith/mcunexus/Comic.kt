package com.droidsmith.mcunexus

import androidx.annotation.DrawableRes

data class Comic(
    val title: String,
    @DrawableRes val iconId: Int
)