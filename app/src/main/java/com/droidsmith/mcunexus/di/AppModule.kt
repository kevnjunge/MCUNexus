package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.data.network.MCUApiService
import com.droidsmith.mcunexus.data.network.MarvelUpcomingApiService
import com.droidsmith.mcunexus.data.repository.MCURepositoryImpl
import com.droidsmith.mcunexus.data.repository.MarvelUpcomingRepositoryImpl
import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.domain.repository.MarvelUpcomingRepository
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
            .baseUrl(Constants.MARVEL_BASE_URL)
            .build()
            .create(MCUApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesMarvelUpcomingApiService():MarvelUpcomingApiService{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.UPCOMING_BASEURL)
            .build()
            .create(MarvelUpcomingApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesMarvelRepository(api: MCUApiService): MCURepository {
        return MCURepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesMarvelUpcomingRepository(api:MarvelUpcomingApiService):MarvelUpcomingRepository{
        return MarvelUpcomingRepositoryImpl(api)
    }
}
