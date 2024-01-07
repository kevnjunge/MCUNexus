package com.droidsmith.mcunexus.data.network

import com.droidsmith.mcunexus.data.network.allCharacterResponse.CharactersDTO
import com.droidsmith.mcunexus.data.network.allComicsResponse.Comic
import com.droidsmith.mcunexus.data.network.allEventsResponse.Events
import com.droidsmith.mcunexus.data.network.allSeriesResponse.Series
import com.droidsmith.mcunexus.data.network.allStoriesResponse.Stories
import com.droidsmith.mcunexus.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MCUApiService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0",
        @Query("limit") limit: String = "99"
    ): CharactersDTO

    @GET("characters")
    suspend fun searchCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("name") name: String,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0"
    ): CharactersDTO

    @GET("characters/{character_id}/comics")
    suspend fun getCharacterComics(
        @Path("character_id") characterID: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0"
    ): Comic

    @GET("characters/{character_id}/series")
    suspend fun getCharacterSeries(
        @Path("character_id") characterID: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0"

    ): Series

    @GET("characters/{character_id}/stories")
    suspend fun getCharacterStories(
        @Path("character_id") characterID: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0"

    ): Stories

    @GET("characters/{character_id}/events")
    suspend fun getCharacterEvents(
        @Path("character_id") characterID: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0"

    ): Events

    @GET("comics")
    suspend fun getComics(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0",
        @Query("limit") limit: String = "99"
    ): Comic

    @GET("series")
    suspend fun getSeries(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("offset") offset: String = "0",
        @Query("limit") limit: String = "99"
    ): Series


}



