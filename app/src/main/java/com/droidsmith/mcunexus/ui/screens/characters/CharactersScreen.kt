package com.droidsmith.mcunexus.ui.screens.characters

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.droidsmith.mcunexus.R
import com.droidsmith.mcunexus.domain.model.Character
import com.droidsmith.mcunexus.ui.screens.Screen
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    navController: NavHostController,
    viewModel: CharactersViewModel = hiltViewModel()
) {

    // Collect data from the ViewModel
    val mcuListState by viewModel.mcuValue.collectAsState()
    val searchListState by viewModel.characterSearchListState.collectAsState()
    Log.d("CharacterScreen", "Search Results: ${searchListState.characterSearchList}")

    LaunchedEffect(viewModel) {
        // Fetch data when the Composable is first created
        viewModel.getAllCharactersData(offset = 0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MARVEL",
                        fontFamily = marvel,
                        color = TextWhite
                    )
                },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = navigateUp) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back Button",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MarvelRed
                )
            )

        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
            ) {
                Column {
                    SearchCharacterSection(viewModel = viewModel)

                    //Display characters based on whether it's a regular list or a search result

                    val charactersToDisplay = if (searchListState.characterSearchList.isNotEmpty()) {
                        searchListState.characterSearchList
                    } else {
                        mcuListState.characterList
                    }
                    if (searchListState.isLoading) {
                        // Show loading indicator during search
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    } else if (charactersToDisplay.isNotEmpty()) {
                        // Display search results or regular list
                        CharactersDisplay(
                            charactersList = charactersToDisplay,
                            searchResultsList = searchListState.characterSearchList,
                            navController = navController
                        )
                    } else if (mcuListState.isLoading) {
                        // Show loading indicator for regular list
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    } else if (mcuListState.error.isNotEmpty() || searchListState.error.isNotEmpty()) {
                        // Display Error Message
                        Text(
                            text = "Something ain't right check your internet ${
                                mcuListState.error +
                                        searchListState.error
                            }",
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                }

            }
        },
        containerColor = MarvelRed
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCharacterSection(viewModel: CharactersViewModel) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            text = "MARVEL CHARACTERS",
            style = MaterialTheme.typography.displaySmall,
            fontFamily = marvel,
            color = TextWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {

        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = text,
            shape = ShapeDefaults.Small,
            onQueryChange = {
                text = it
            },
            onSearch = {
                active = false
                viewModel.searchCharacters(offset = 0, query = text)
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Search Character...")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier
                            .clickable {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                }

                            },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon"
                    )
                }
            }
        ) {
            // TODO: Add Search History

        }


    }
}

@Composable
fun CharactersDisplay(
    charactersList: List<Character>,
    searchResultsList: List<Character>,
                      navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            val combinedList = if (searchResultsList.isNotEmpty()) {
                searchResultsList
            } else {
                charactersList
            }

            items(combinedList.size) {
                CharacterCard(characters = combinedList[it], navController = navController)
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCard(
    characters: Character,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .clip(CutCornerShape(bottomEnd = 16.dp))
            .clickable {
                // Navigate to the CharactersDetail screen and pass the character ID as a navigation argument
                navController.navigate(
                    route = Screen.CharacterDetail.passId(
                        characters.id,
                        navController
                    )
                )
            },
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column() {
            Box(modifier = Modifier.fillMaxWidth()) {
                val imageUrl = "${
                    characters.thumbnail.replace(
                        "http",
                        "https"
                    )
                }/portrait_xlarge.${characters.thumbnailExt}"

                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = characters.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Red)
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = characters.name.uppercase(Locale.ROOT),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 20.sp,
                fontFamily = marvel,
                color = Color.White,
                modifier = Modifier
                    .width(IntrinsicSize.Max) // Prevent text wrapping
                    .basicMarquee()
            )
        }

    }

}


