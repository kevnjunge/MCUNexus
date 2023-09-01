package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.data.network.MCUApiService
import com.droidsmith.mcunexus.data.repository.MCURepositoryImpl
import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.util.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMCUApiService():MCUApiService{
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(MCUApiService::class.java)
    }
    @Provides
    @Singleton
    fun providesMarvelRepository(api:MCUApiService):MCURepository{
        return MCURepositoryImpl(api)
    }
}
