package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.domain.usecases.SearchCharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SearchCharacterUseCaseModule {

    @Provides
    fun provideSearchCharacterUseCase(repository: MCURepository): SearchCharacterUseCase {
        return SearchCharacterUseCase(repository)
    }
}