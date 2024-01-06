package com.droidsmith.mcunexus.ui.screens.comics

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.droidsmith.mcunexus.R
import com.droidsmith.mcunexus.domain.model.Comic
import com.droidsmith.mcunexus.ui.components.SearchSection
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComicsScreen(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    viewModel: ComicsViewModel = hiltViewModel()
) {

    //Collect data from ViewModel
    val comicListState by viewModel.allComicListState.collectAsState()

    LaunchedEffect(viewModel) {

        viewModel.getAllComicsData(offset = 0, characterId = null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "COMICS",
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
                    SearchSection(
                        viewModel = viewModel,
                        title = "MARVEL COMICS",
                        placeholderText = "Search Comics...",
                        onSearch = { query ->

                        }
                    )

//                    if (comicListState.characterList.isNotEmpty()) {
//                        CharactersDisplay(charactersList = mcuListState.characterList, navController = navController)
//                    } else if (mcuListState.isLoading) {
//                        // Show loading indicator
//                        CircularProgressIndicator(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(16.dp)
//                        )
//                    } else if (mcuListState.error.isNotEmpty()) {
//                        // Show error message
//                        Text(
//                            text = mcuListState.error,
//                            modifier = Modifier.padding(16.dp)
//                        )
//                    }

                    if (comicListState.comicList.isNotEmpty()) {
                        ComicDisplay(comicsList = comicListState.comicList)
                    } else if (comicListState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    } else if (comicListState.error.isNotEmpty()) {
                        Text(
                            text = "Something ain't right check your internet ${comicListState.error}",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }

        },
        containerColor = MarvelRed
    )
}


@Composable
fun ComicDisplay(
    comicsList: List<Comic>,
//    comicSearchResultsList: List<Comic>,
//    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
//            val combinedList = if (comicSearchResultsList.isNotEmpty()) {
//                comicSearchResultsList
//            } else {
//                comicsList
//            }

            items(comicsList.size) {
                CharacterCard(comics = comicsList[it])
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCard(
    comics: Comic
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .clip(CutCornerShape(bottomEnd = 16.dp))
            .clickable {
                //TODO: Comics Details

            },
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column() {
            Box(modifier = Modifier.fillMaxWidth()) {
                val imageUrl = "${
                    comics.thumbnail.replace(
                        "http",
                        "https"
                    )
                }/portrait_xlarge.${comics.thumbnailExt}"

                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = comics.title,
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
                text = comics.title.uppercase(Locale.ROOT),
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




