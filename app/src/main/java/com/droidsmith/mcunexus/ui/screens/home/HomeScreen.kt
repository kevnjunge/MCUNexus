package com.droidsmith.mcunexus.ui.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.droidsmith.mcunexus.Comic
import com.droidsmith.mcunexus.R
import com.droidsmith.mcunexus.ui.MCUListState
import com.droidsmith.mcunexus.ui.screens.Screen
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val marvelUpcomingState by viewModel.marvelUpcomingState.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getMarvelUpcomingData()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "MARVEL",
                        style = MaterialTheme.typography.displayLarge,
                        fontFamily = marvel,
                        color = TextWhite
                    )

                },
                colors = topAppBarColors(
                    containerColor = MarvelRed,
                )
            )

        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues),

                ) {
                Column {

                    MarvelsUpcoming(marvelUpcomingState)
                    ComicsContent(
                        comicItems = listOf(
                            Comic(
                                title = "CHARACTERS",
                                R.drawable.iron_man
                            ),
                            Comic(
                                title = "COMICS",
                                R.drawable.comic
                            ),
                            Comic(
                                title = "SERIES",
                                R.drawable.iron_man
                            ),
                            Comic(
                                title = "EVENTS",
                                R.drawable.iron_man
                            ),
                            Comic(
                                title = "CREATORS",
                                R.drawable.iron_man
                            ),
                            Comic(
                                title = "STORIES",
                                R.drawable.comics
                            )
                        ),
                        navController = navController
                    )
                }
            }


        },
        containerColor = MarvelRed
    )


}


@Composable
fun MarvelsUpcoming(
    marvelUpcomingState: MCUListState
) {

    Box(modifier = Modifier.fillMaxWidth())
    {
        Text(
            text = "MARVEL'S UPCOMING ",
            style = MaterialTheme.typography.displaySmall,
            fontFamily = marvel,
            color = TextWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(horizontal = 0.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .padding(6.dp)

        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(marvelUpcomingState.marvelUpcoming?.poster_url)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = marvelUpcomingState.marvelUpcoming?.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(3.dp))
                    .size(120.dp)
                    .width(72.dp)
            )

        }
        Column(
            modifier = Modifier
                .align(Alignment.Top)
        ) {
            Text(
                text = marvelUpcomingState.marvelUpcoming?.title.orEmpty().uppercase(),
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = marvel,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(6.dp)
            )
            Text(
                text = marvelUpcomingState.marvelUpcoming?.days_until.toString() + " DAYS TO GO!",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = marvel,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(6.dp)
                )
        }


    }

}

@Composable
fun ComicsContent(
    comicItems: List<Comic>,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(comicItems.size) { index ->
                ComicsContentItems(
                    comic = comicItems[index],
                    index = index,
                    onItemClick = { clickedIndex ->
                        when (clickedIndex) {
                            0 -> navController.navigate(route = Screen.Character.route)
                            1 -> navController.navigate(route = Screen.Comics.route)
                            2 -> navController.navigate(route = Screen.Series.route)
                            3 -> navController.navigate(route = Screen.Events.route)
                            4 -> navController.navigate(route = Screen.Creators.route)
                            5 -> navController.navigate(route = Screen.Stories.route)
                        }
                    }
                )
            }

        }

    }

}


@Composable
fun ComicsContentItems(
    comic: Comic,
    index: Int,
    onItemClick: (Int) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .fillMaxSize()
            .clickable {
                onItemClick.invoke(index)
            }

    ) {
        Text(
            text = comic.title,
            style = MaterialTheme.typography.bodyLarge,
            fontFamily = marvel,
            fontSize = 18.sp,
            lineHeight = 26.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )
        Image(
            painter = painterResource(id = comic.iconId),
            contentDescription = comic.title,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .align(Alignment.Center)
        )

    }


}
