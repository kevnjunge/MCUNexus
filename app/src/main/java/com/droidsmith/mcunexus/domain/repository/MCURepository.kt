package com.droidsmith.mcunexus.domain.repository

import com.droidsmith.mcunexus.data.network.allCharacterResponse.CharactersDTO
import com.droidsmith.mcunexus.data.network.allComicsResponse.Comic
import com.droidsmith.mcunexus.data.network.allEventsResponse.Events
import com.droidsmith.mcunexus.data.network.allSeriesResponse.Series
import com.droidsmith.mcunexus.data.network.allStoriesResponse.Stories

interface MCURepository {

    suspend fun getAllCharacter(offset: Int): CharactersDTO
    suspend fun searchCharacter(offset: Int, name: String): CharactersDTO
    suspend fun getAllComicByCharacterId(offset: Int, characterId: String): Comic
    suspend fun getAllSeriesByCharacterId(offset: Int, characterId: String): Series
    suspend fun getAllStoriesByCharacterId(offset: Int, characterId: String): Stories
    suspend fun getAllEventsByCharacterId(offset: Int, characterId: String): Events
    suspend fun getAllComics(): Comic
    suspend fun getAllSeries(): Series

}