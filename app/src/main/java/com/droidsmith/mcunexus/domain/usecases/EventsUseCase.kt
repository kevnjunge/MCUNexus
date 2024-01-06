package com.droidsmith.mcunexus.domain.usecases

import com.droidsmith.mcunexus.domain.model.Events
import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class EventsUseCase @Inject constructor(
    private val repository: MCURepository
) {
    operator fun invoke(offset: Int, characterId: String): Flow<Response<List<Events>>> = flow {
        try {
            emit(Response.Loading())
            val list = repository.getAllEventsByCharacterId(
                offset,
                characterId = characterId
            ).data.results.map {
                it.toEvent()
            }
            emit(Response.Success(list))
        } catch (e: HttpException) {
            emit(Response.Error(e.printStackTrace().toString()))
        } catch (e: HttpException) {
            emit(Response.Error(e.printStackTrace().toString()))
        }

    }
}