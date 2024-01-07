package com.droidsmith.mcunexus.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidsmith.mcunexus.domain.usecases.MarvelUpcomingUseCase
import com.droidsmith.mcunexus.ui.MCUListState
import com.droidsmith.mcunexus.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val marvelUpcomingUseCase: MarvelUpcomingUseCase
) : ViewModel() {
    private val _marvelUpcomingState = MutableStateFlow(MCUListState())
    val marvelUpcomingState: StateFlow<MCUListState> = _marvelUpcomingState.stateIn(viewModelScope, SharingStarted.Lazily, _marvelUpcomingState.value)

    fun getMarvelUpcomingData() {
        viewModelScope.launch {
            marvelUpcomingUseCase().collect { response ->
                _marvelUpcomingState.value =  when (response) {
                    is Response.Success -> {
                        MCUListState(marvelUpcoming = response.data)
                    }
                    is Response.Loading -> {
                        MCUListState(isLoading = true)
                    }
                    is Response.Error -> {
                        MCUListState(error = response.message ?: "An unexpected error occurred")
                    }
                }
            }
        }
    }

}