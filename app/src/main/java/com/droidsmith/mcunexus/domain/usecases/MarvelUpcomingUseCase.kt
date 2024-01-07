package com.droidsmith.mcunexus.domain.usecases

import com.droidsmith.mcunexus.domain.model.MarvelUpcoming
import com.droidsmith.mcunexus.domain.repository.MarvelUpcomingRepository
import com.droidsmith.mcunexus.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MarvelUpcomingUseCase @Inject  constructor(
    private val repository: MarvelUpcomingRepository
){
    operator fun invoke(): Flow<Response<MarvelUpcoming>> = flow {
        try {
            emit(Response.Loading())

            val response = repository.getUpcoming()
            val marvelUpcoming = response.toUpcoming()
            emit(Response.Success(marvelUpcoming))
        }catch (e:HttpException){
            emit(Response.Error(e.printStackTrace().toString()))
        }catch (e:IOException){
            emit(Response.Error(e.printStackTrace().toString()))
        }
    }
}