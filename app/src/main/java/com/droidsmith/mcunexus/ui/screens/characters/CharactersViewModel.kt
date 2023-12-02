package com.droidsmith.mcunexus.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidsmith.mcunexus.domain.usecases.CharactersUseCase
import com.droidsmith.mcunexus.ui.MCUListState
import com.droidsmith.mcunexus.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
) : ViewModel() {
    val _mcuValue = MutableStateFlow(MCUListState())
    val mcuValue: StateFlow<MCUListState> = _mcuValue.stateIn(viewModelScope, SharingStarted.Lazily, _mcuValue.value)

    fun getAllCharactersData(offset: Int) = viewModelScope.launch(Dispatchers.IO) {
        charactersUseCase(offset = offset).collect {
            when (it) {
                is Response.Success -> {
                    _mcuValue.value = MCUListState(characterList = it.data ?: emptyList())
                }
                is Response.Loading -> {
                    _mcuValue.value = MCUListState(isLoading = true)
                }
                is Response.Error -> {
                    _mcuValue.value = MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                }
            }
        }
    }
}