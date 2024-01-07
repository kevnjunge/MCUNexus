package com.droidsmith.mcunexus.ui.screens.series

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
import com.droidsmith.mcunexus.domain.model.Series
import com.droidsmith.mcunexus.ui.components.SearchSection
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeriesScreen(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    viewModel: SeriesViewModel = hiltViewModel()
) {
    val seriesListState by viewModel.allSeriesListState.collectAsState()

    LaunchedEffect(viewModel) {

        viewModel.getAllSeriesData(offset = 0, characterId = null)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "SERIES",
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
                        title = "MARVEL SERIES",
                        placeholderText = "Search Series...",
                        onSearch = { query ->

                        }
                    )

                    if (seriesListState.seriesList.isNotEmpty()) {
                        SeriesDisplay(seriesList = seriesListState.seriesList)
                    } else if (seriesListState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    } else if (seriesListState.error.isNotEmpty()) {
                        Text(
                            text = "Something ain't right check your internet ${seriesListState.error}",
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
fun SeriesDisplay(
    seriesList: List<Series>
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
            items(seriesList.size) {
                SeriesCard(series = seriesList[it])
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SeriesCard(
    series: Series
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .clip(CutCornerShape(bottomEnd = 16.dp))
            .clickable {
                //TODO: Series Details

            },
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column() {
            Box(modifier = Modifier.fillMaxWidth()) {
                val imageUrl = "${
                    series.thumbnail.replace(
                        "http",
                        "https"
                    )
                }/portrait_xlarge.${series.thumbnailExt}"

                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = series.title,
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
                text = series.title.uppercase(Locale.ROOT),
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



