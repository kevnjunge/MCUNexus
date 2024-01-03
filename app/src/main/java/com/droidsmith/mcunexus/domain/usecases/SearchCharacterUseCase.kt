package com.droidsmith.mcunexus.domain.usecases

import com.droidsmith.mcunexus.domain.model.Character
import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchCharacterUseCase @Inject constructor(
    private val repository: MCURepository
) {
    operator fun invoke(offset: Int, query: String): Flow<Response<List<Character>>> = flow {
        try {
            emit(Response.Loading())
            val searchResult =
                repository.searchCharacter(offset = offset, name = query).data.results.map {
                    it.toCharacter()
                }
            emit(Response.Success(searchResult))
        } catch (e: HttpException) {
            emit(Response.Error(e.printStackTrace().toString()))
        } catch (e: IOException) {
            emit(Response.Error(e.printStackTrace().toString()))
        }
    }
}