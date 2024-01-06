package com.droidsmith.mcunexus.domain.usecases

import com.droidsmith.mcunexus.domain.model.Stories
import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class StoriesUseCase @Inject constructor(
    private val repository: MCURepository
) {
    operator fun invoke(offset: Int, characterId: String): Flow<Response<List<Stories>>> = flow {
        try {
            emit(Response.Loading())
            val list =
                repository.getAllStoriesByCharacterId(
                    offset,
                    characterId = characterId
                ).data.results.map {
                    it.toStories()
                }
            emit(Response.Success(list))
        } catch (e: HttpException) {
            emit(Response.Error(e.printStackTrace().toString()))
        } catch (e: HttpException) {
            emit(Response.Error(e.printStackTrace().toString()))
        }
    }
}