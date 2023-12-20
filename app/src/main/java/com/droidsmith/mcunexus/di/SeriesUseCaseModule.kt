package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.domain.usecases.SeriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SeriesUseCaseModule {

    @Provides
    fun providesSeriesUseCase(repository: MCURepository): SeriesUseCase {
        return SeriesUseCase(repository)
    }
}