package com.droidsmith.mcunexus.ui.screens.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidsmith.mcunexus.domain.usecases.SeriesUseCase
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
class SeriesViewModel @Inject constructor(
    private val seriesUseCase: SeriesUseCase
) : ViewModel() {

    val _allSeriesListState = MutableStateFlow(MCUListState())
    val allSeriesListState: StateFlow<MCUListState> =
        _allSeriesListState.stateIn(viewModelScope, SharingStarted.Lazily, _allSeriesListState.value )

    fun getAllSeriesData(offset: Int, characterId: String?) =
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase(offset = offset, characterId = characterId).collect {
                when (it) {
                    is Response.Success -> {
                        _allSeriesListState.value =
                            MCUListState(seriesList = it.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _allSeriesListState.value = MCUListState(isLoading = true)
                    }

                    is Response.Error -> {
                        _allSeriesListState.value =
                            MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                    }

                }

            }
        }

}