package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.domain.usecases.ComicsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ComicUseCaseModule {

    @Provides
    fun providesComicUseCase(repository: MCURepository): ComicsUseCase {
        return ComicsUseCase(repository)
    }
}