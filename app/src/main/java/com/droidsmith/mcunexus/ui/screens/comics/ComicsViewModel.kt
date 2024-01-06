package com.droidsmith.mcunexus.ui.screens.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidsmith.mcunexus.domain.usecases.ComicsUseCase
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
class ComicsViewModel @Inject constructor(
    private val comicsUseCase: ComicsUseCase
) : ViewModel() {

    val _allComicListState = MutableStateFlow(MCUListState())
    val allComicListState: StateFlow<MCUListState> =
        _allComicListState.stateIn(viewModelScope, SharingStarted.Lazily, _allComicListState.value)


    fun getAllComicsData(offset: Int, characterId: String?) =
        viewModelScope.launch(Dispatchers.IO) {
            comicsUseCase(offset = offset, characterId = characterId).collect {
                when (it) {
                    is Response.Success -> {
                        _allComicListState.value = MCUListState(comicList = it.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _allComicListState.value = MCUListState(isLoading = true)
                    }

                    is Response.Error -> {
                        _allComicListState.value =
                            MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                    }
                }
            }
        }

}