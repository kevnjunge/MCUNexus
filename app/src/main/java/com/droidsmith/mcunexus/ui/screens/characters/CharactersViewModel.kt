package com.droidsmith.mcunexus.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidsmith.mcunexus.domain.usecases.CharactersUseCase
import com.droidsmith.mcunexus.domain.usecases.ComicsUseCase
import com.droidsmith.mcunexus.domain.usecases.EventsUseCase
import com.droidsmith.mcunexus.domain.usecases.SearchCharacterUseCase
import com.droidsmith.mcunexus.domain.usecases.SeriesUseCase
import com.droidsmith.mcunexus.domain.usecases.StoriesUseCase
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
    private val charactersUseCase: CharactersUseCase,
    private val searchCharacterUseCase: SearchCharacterUseCase,
    private val comicsUseCase: ComicsUseCase,
    private val seriesUseCase: SeriesUseCase,
    private val storiesUseCase: StoriesUseCase,
    private val eventsUseCase: EventsUseCase
) : ViewModel() {
    val _mcuValue = MutableStateFlow(MCUListState())
    val mcuValue: StateFlow<MCUListState> =
        _mcuValue.stateIn(viewModelScope, SharingStarted.Lazily, _mcuValue.value)

    val _comicListState = MutableStateFlow(MCUListState())
    val comicListState: StateFlow<MCUListState> =
        _comicListState.stateIn(viewModelScope, SharingStarted.Lazily, _comicListState.value)

    val _searchListState = MutableStateFlow(MCUListState())
    val characterSearchListState: StateFlow<MCUListState> =
        _searchListState.stateIn(viewModelScope, SharingStarted.Lazily, _searchListState.value)

    val _seriesListState = MutableStateFlow(MCUListState())
    val seriesListState: StateFlow<MCUListState> =
        _seriesListState.stateIn(viewModelScope, SharingStarted.Lazily, _seriesListState.value)

    val _storiesListState = MutableStateFlow(MCUListState())
    val storiesListState: StateFlow<MCUListState> =
        _storiesListState.stateIn(viewModelScope, SharingStarted.Lazily, _storiesListState.value)

    val _eventsListState = MutableStateFlow(MCUListState())
    val eventsListState: StateFlow<MCUListState> =
        _eventsListState.stateIn(viewModelScope, SharingStarted.Lazily, _eventsListState.value)

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
                    _mcuValue.value =
                        MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                }
            }
        }
    }

    // Function to perform search
    fun searchCharacters(offset: Int, query: String) = viewModelScope.launch(Dispatchers.IO) {
        searchCharacterUseCase(offset = offset, query = query).collect {
            when (it) {
                is Response.Success -> {
                    _searchListState.value = MCUListState(characterList = it.data ?: emptyList())
                }

                is Response.Loading -> {
                    _searchListState.value = MCUListState(isLoading = true)
                }

                is Response.Error -> {
                    _searchListState.value =
                        MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                }
            }
        }
    }

    fun getAllCharacterComic(offset: Int, characterId: String) =
        viewModelScope.launch(Dispatchers.IO) {
            comicsUseCase(offset = offset, characterId = characterId).collect {
                when (it) {
                    is Response.Success -> {
                        _comicListState.value = MCUListState(comicList = it.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _comicListState.value = MCUListState(isLoading = true)
                    }

                    is Response.Error -> {
                        _comicListState.value =
                            MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                    }
                }
            }
        }

    fun getAllCharacterSeries(offset: Int, characterId: String) =
        viewModelScope.launch(Dispatchers.IO) {
            seriesUseCase(offset = offset, characterId = characterId).collect {
                when (it) {
                    is Response.Success -> {
                        _seriesListState.value = MCUListState(seriesList = it.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _seriesListState.value = MCUListState(isLoading = true)
                    }

                    is Response.Error -> {
                        _searchListState.value =
                            MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                    }
                }
            }

        }

    fun getAllCharacterStories(offset: Int, characterId: String) =
        viewModelScope.launch(Dispatchers.IO) {
            storiesUseCase(offset = offset, characterId = characterId).collect {
                when (it) {
                    is Response.Success -> {
                        _storiesListState.value = MCUListState(storiesList = it.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _storiesListState.value = MCUListState(isLoading = true)
                    }

                    is Response.Error -> {
                        _storiesListState.value =
                            MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                    }
                }
            }
        }

    fun getAllCharacterEvents(offset: Int, characterId: String) =
        viewModelScope.launch(Dispatchers.IO) {
            eventsUseCase(offset = offset, characterId = characterId).collect {
                when (it) {
                    is Response.Success -> {
                        _eventsListState.value = MCUListState(eventsList = it.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _eventsListState.value = MCUListState(isLoading = true)
                    }

                    is Response.Error -> {
                        _eventsListState.value =
                            MCUListState(error = it.message ?: "An UnexpectedError Occurred")
                    }
                }
            }
        }


}