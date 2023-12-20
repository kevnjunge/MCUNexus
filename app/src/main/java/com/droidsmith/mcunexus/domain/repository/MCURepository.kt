package com.droidsmith.mcunexus.domain.repository

import com.droidsmith.mcunexus.data.network.allCharacterResponse.CharactersDTO
import com.droidsmith.mcunexus.data.network.allComicsResponse.Comic
import com.droidsmith.mcunexus.data.network.allEventsResponse.Events
import com.droidsmith.mcunexus.data.network.allSeriesResponse.Series
import com.droidsmith.mcunexus.data.network.allStoriesResponse.Stories

interface MCURepository {

    suspend fun getAllCharacter(offset: Int): CharactersDTO
    suspend fun getAllComic(offset: Int, characterId: String): Comic
    suspend fun getAllSeries(offset: Int, characterId: String): Series
    suspend fun getAllStories(offset: Int, characterId: String): Stories
    suspend fun getAllEvents(offset: Int, characterId: String): Events
}