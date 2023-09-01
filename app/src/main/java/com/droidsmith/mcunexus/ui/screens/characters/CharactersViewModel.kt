package com.droidsmith.mcunexus.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidsmith.mcunexus.domain.usecases.CharactersUseCase
import com.droidsmith.mcunexus.ui.MCUListState
import com.droidsmith.mcunexus.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharactersUseCase
):ViewModel(){
    private val mcuValue = MutableStateFlow(MCUListState())
    val _mcuValue: StateFlow<MCUListState> = mcuValue

    fun getAllCharactersData(offset:Int) = viewModelScope.launch(Dispatchers.IO) {
        charactersUseCase(offset = offset).collect{
            when(it){
                is Response.Success -> {
                    mcuValue.value = MCUListState(characterList = it.data?: emptyList())

                }
                is Response.Loading ->{
                    mcuValue.value = MCUListState(isLoading = true)
                }
                is Response.Error ->{
                    mcuValue.value = MCUListState(error = it.message?:"An UnexpectedError Occurred")
                }
            }
        }
    }
}