package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.domain.repository.MarvelUpcomingRepository
import com.droidsmith.mcunexus.domain.usecases.MarvelUpcomingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MarvelUpcomingUseCaseModule {

    @Provides
    fun provideMarvelUpcomingUseCase(repository: MarvelUpcomingRepository): MarvelUpcomingUseCase {
        return MarvelUpcomingUseCase(repository)
    }
}
