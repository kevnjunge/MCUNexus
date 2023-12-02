package com.droidsmith.mcunexus.ui.screens.characterDetail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.droidsmith.mcunexus.R
import com.droidsmith.mcunexus.domain.model.Character
import com.droidsmith.mcunexus.ui.Characters
import com.droidsmith.mcunexus.ui.screens.CHARACTER_DETAIL_ARGUMENT_KEY
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    navController: NavHostController,
    charactersList: List<Character>
) {
//    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntry
    val characterId = navBackStackEntry?.arguments?.getInt(CHARACTER_DETAIL_ARGUMENT_KEY)

    Log.d("Navigation", "Received character ID: $characterId")

    val selectedCharacter = charactersList.find { it.id == characterId }

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
                colors = topAppBarColors(
                    containerColor = MarvelRed
                )
            )

        },
        content = {
            // Your screen content goes here
            Column {


                selectedCharacter?.let { character ->
                    CharacterDetails(character = character)
                }

                CharacterComics(
                    charactersList = listOf(
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "BLACK PANTHER",
                            R.drawable.black_panther
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.iron_man
                        ),
                        Characters(
                            characterName = "IRON MAN",
                            R.drawable.trial_img
                        )
                    )
                )

            }
        },
        containerColor = MarvelRed
    )
}

@Composable
fun CharacterDetails(
    character: Character
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(top = 8.dp)
    ) {
        //TODO: Remove this text and add something to provide the margin space( Spacer Did Not Work Well)
        Text(
            text = character.name,
            style = MaterialTheme.typography.displaySmall,
            fontFamily = marvel,
            color = MarvelRed,
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
                .size(120.dp)
                .width(72.dp)
                .padding(8.dp)

        ) {
            val imageUrl = "${
                character.thumbnail.replace(
                    "http",
                    "https"
                )
            }/portrait_xlarge.${character.thumbnailExt}"

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                //TODO: Find better images
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
//            Image(
//                painter = painterResource(id = R.drawable.trial_img),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(120.dp)
//                    .width(72.dp)
//
//            )

        }
        Column(
            modifier = Modifier
                .align(Alignment.Top)
        ) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = marvel,
                fontSize = 24.sp

            )
            Text(
                text = character.description.ifBlank {
                    "Character description not available"
                },
                maxLines = 10,
                style = MaterialTheme.typography.bodyMedium,


                )
        }


    }
}

@Composable
fun CharacterComics(charactersList: List<Characters>) {
    // TODO: Change from characters to comics once you implement the API

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "COMICS",
                style = MaterialTheme.typography.displaySmall,
                fontFamily = marvel,
                color = TextWhite,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        LazyRow(
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(charactersList.size) {
                CharacterComicItems(characters = charactersList[it])
            }
        }
    }


}

@Composable
fun CharacterComicItems(
    characters: Characters
) {
    // TODO: Change this to comic items
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(all = 12.dp)

        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .size(size = 72.dp),
                    painter = painterResource(id = characters.characterImage),
                    contentDescription = characters.characterName

                )

            }
            Spacer(
                modifier = Modifier
                    .padding(5.dp)
            ) // gap between image and text
            Text(
                text = characters.characterName,
                fontSize = 20.sp,
                fontFamily = marvel,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth()
            )
        }
    }

}


@Composable
fun CharacterSeries() {

}

@Composable
fun CharacterStories() {

}
