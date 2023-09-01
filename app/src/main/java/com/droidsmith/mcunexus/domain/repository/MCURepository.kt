package com.droidsmith.mcunexus.domain.repository

import com.droidsmith.mcunexus.data.network.dto.CharactersDTO

interface MCURepository {

    suspend fun getAllCharacter(offset:Int):CharactersDTO
}