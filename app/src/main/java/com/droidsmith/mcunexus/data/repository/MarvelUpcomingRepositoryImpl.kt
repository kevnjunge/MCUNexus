package com.droidsmith.mcunexus.data.repository

import com.droidsmith.mcunexus.data.network.MarvelUpcomingApiService
import com.droidsmith.mcunexus.data.network.marvelUpcoming.MarvelUpcoming
import com.droidsmith.mcunexus.domain.repository.MarvelUpcomingRepository
import javax.inject.Inject

class MarvelUpcomingRepositoryImpl @Inject constructor(
    private val api: MarvelUpcomingApiService
):MarvelUpcomingRepository {
    override suspend fun getUpcoming(): MarvelUpcoming {
        return api.getUpcoming()
    }

}