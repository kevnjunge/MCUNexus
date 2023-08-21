package com.droidsmith.mcunexus.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidsmith.mcunexus.R
import com.droidsmith.mcunexus.ui.Characters
import com.droidsmith.mcunexus.ui.theme.MarvelRed
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen() {
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
                    SearchCharacterSection()
                    CharactersDisplay(
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

            }
        },
        containerColor = MarvelRed
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCharacterSection() {
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
fun CharactersDisplay(charactersList: List<Characters>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(charactersList.size) {
                CharacterCard(characters = charactersList[it])
            }
        }
    }

}

@Composable
fun CharacterCard(
    characters: Characters
) {
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


