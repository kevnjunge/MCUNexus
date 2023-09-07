package com.droidsmith.mcunexus.di

import com.droidsmith.mcunexus.domain.repository.MCURepository
import com.droidsmith.mcunexus.domain.usecases.CharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CharactersUseCaseModule {

    @Provides
    fun provideCharactersUseCase(repository: MCURepository): CharactersUseCase {
        return CharactersUseCase(repository)
    }
}
