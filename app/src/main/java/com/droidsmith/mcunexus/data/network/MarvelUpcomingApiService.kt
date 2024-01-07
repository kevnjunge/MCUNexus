package com.droidsmith.mcunexus.data.network

import com.droidsmith.mcunexus.data.network.marvelUpcoming.MarvelUpcoming
import retrofit2.http.GET

interface MarvelUpcomingApiService {

    @GET("api")
    suspend fun getUpcoming():MarvelUpcoming

}