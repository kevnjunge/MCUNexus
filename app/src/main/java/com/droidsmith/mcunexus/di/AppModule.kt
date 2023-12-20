package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.data.network.MCUApiService
import com.droidsmith.mcunexus.data.repository.MCURepositoryImpl
import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMCUApiService(): MCUApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(MCUApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesMarvelRepository(api: MCUApiService): MCURepository {
        return MCURepositoryImpl(api)
    }
}
