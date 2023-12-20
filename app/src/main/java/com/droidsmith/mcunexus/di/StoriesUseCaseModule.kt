package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.domain.usecases.StoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object StoriesUseCaseModule {

    @Provides
    fun providesStoriesUseCase(repository: MCURepository): StoriesUseCase {
        return StoriesUseCase(repository)
    }
}