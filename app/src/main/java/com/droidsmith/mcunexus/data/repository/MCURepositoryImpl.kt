package com.droidsmith.mcunexus.data.repository

import com.droidsmith.mcunexus.data.network.MCUApiService
import com.droidsmith.mcunexus.data.network.dto.CharactersDTO
import com.droidsmith.mcunexus.domain.repository.MCURepository
import javax.inject.Inject

class MCURepositoryImpl @Inject constructor(
    private  val api:MCUApiService
):MCURepository{
    override suspend fun getAllCharacter(offset: Int): CharactersDTO {
        return api.getCharacters(offset = offset.toString())
    }
}