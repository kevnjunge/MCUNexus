package com.droidsmith.mcunexus.data.repository

import com.droidsmith.mcunexus.data.network.MCUApiService
import com.droidsmith.mcunexus.data.network.allCharacterResponse.CharactersDTO
import com.droidsmith.mcunexus.data.network.allComicsResponse.Comic
import com.droidsmith.mcunexus.data.network.allEventsResponse.Events
import com.droidsmith.mcunexus.data.network.allSeriesResponse.Series
import com.droidsmith.mcunexus.data.network.allStoriesResponse.Stories
import com.droidsmith.mcunexus.domain.repository.MCURepository
import javax.inject.Inject

class MCURepositoryImpl @Inject constructor(
    private val api: MCUApiService
) : MCURepository {
    override suspend fun getAllCharacter(offset: Int): CharactersDTO {
        return api.getCharacters(offset = offset.toString())
    }

    override suspend fun searchCharacter(offset: Int, name: String): CharactersDTO {
        return api.searchCharacters(offset = offset.toString(), name = name)
    }

    override suspend fun getAllComic(offset: Int, characterId: String): Comic {
        return api.getCharacterComics(offset = offset.toString(), characterID = characterId)
    }

    override suspend fun getAllSeries(offset: Int, characterId: String): Series {
        return api.getCharacterSeries(offset = offset.toString(), characterID = characterId)
    }

    override suspend fun getAllStories(offset: Int, characterId: String): Stories {
        return api.getCharacterStories(offset = offset.toString(), characterID = characterId)
    }

    override suspend fun getAllEvents(offset: Int, characterId: String): Events {
        return api.getCharacterEvents(offset = offset.toString(), characterID = characterId)
    }
}