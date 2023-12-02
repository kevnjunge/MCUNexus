package com.droidsmith.mcunexus.data.network

import com.droidsmith.mcunexus.data.network.dto.CharactersDTO
import com.droidsmith.mcunexus.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query


interface MCUApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0"
    ): CharactersDTO


}



