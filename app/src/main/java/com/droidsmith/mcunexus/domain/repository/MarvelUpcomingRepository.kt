package com.droidsmith.mcunexus.domain.repository

import com.droidsmith.mcunexus.data.network.marvelUpcoming.MarvelUpcoming

interface MarvelUpcomingRepository {

    suspend fun getUpcoming():MarvelUpcoming
}