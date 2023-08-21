package com.droidsmith.mcunexus.ui.screens

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen() {
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
                colors = topAppBarColors(
                    containerColor = MarvelRed
                )
            )

        },
        content = {
            // Your screen content goes here
            Column {

                CharacterDetails()
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
fun CharacterDetails() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            text = "ABOMINATION ( EMILY BLONSKY )",
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

        ) {
            Image(
                painter = painterResource(id = R.drawable.trial_img),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .width(72.dp)

            )

        }
        Column(
            modifier = Modifier
                .align(Alignment.Top)
        ) {
            Text(
                text = "ABOMINATION ( EMILY BLONSKY )",
                style = MaterialTheme.typography.bodyLarge,
                fontFamily = marvel,
                fontSize = 24.sp

            )
            Text(
                text = "8Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat, justo vel dignissim posuere, purus risus auctor felis, vel auctor odio metus a urna. Curabitur congue vel justo eget bibendum. Fusce euismod nisl a quam facilisis congue. Vivamus cursus odio eget enim vulputate, sed semper lorem mattis. Vivamus bibendum quam eget eros finibus, vel hendrerit tortor sollicitudin. Nulla facilisi. Integer bibendum in libero et fermentum. Pellentesque non eros semper, vehicula nulla ac, bibendum justo. Nullam sed cursus tortor. Nulla facilisi. Nulla facilisi.\n" +
                        "\n" +
                        "Suspendisse potenti. Sed ac sapien id velit tincidunt volutpat. Fusce fringilla, lorem et consectetur gravida, libero libero congue neque, eu vestibulum purus tortor sit amet felis. Fusce auctor libero ac mi euismod, ac hendrerit justo euismod. Aenean aliquet eu arcu eu volutpat. Duis vel turpis eget velit consectetur hendrerit. Nam dapibus odio id nibh bibendum, ac vestibulum purus ultricies. Integer quis velit a nulla auctor dapibus a a libero. Nullam volutpat in purus sed sollicitudin. In eu urna ut tortor finibus fringilla eu quis ipsum. Sed suscipit elit eu est pellentesque fringilla.\n" +
                        "\n" +
                        "Nunc congue venenatis vestibulum. Aenean varius dui nec ex eleifend interdum. Fusce bibendum mauris sit amet lectus facilisis, vel egestas risus pellentesque. Sed luctus velit vel dolor facilisis, eget efficitur sapien euismod. Integer feugiat nisi in justo feugiat volutpat. Fusce ac arcu non nisl feugiat eleifend. Donec posuere dui ac feugiat dignissim. Vivamus lacinia ipsum vel tortor pharetra, vel volutpat libero vehicula. In egestas eros sit amet tellus consectetur, vel venenatis odio scelerisque. Nulla facilisi. Integer a justo ac nulla feugiat tempus. Integer suscipit efficitur dui, in tempus urna dapibus quis.\n" +
                        "\n" +
                        "Quisque laoreet, erat sed tincidunt cursus, neque quam lacinia enim, eget tempus ipsum justo at quam. Sed scelerisque velit eget tincidunt mattis. Vivamus ullamcorper enim id lorem pellentesque, non mattis quam fringilla. Vivamus sit amet metus sed nisi tincidunt rhoncus id nec arcu. Donec laoreet feugiat elit a fringilla. Sed eu odio nec felis suscipit facilisis. Curabitur vestibulum feugiat risus, id tempor dolor ultricies eu. Curabitur hendrerit tortor a efficitur euismod. Suspendisse feugiat vehicula neque, eu volutpat elit bibendum vel. Aliquam id ultricies purus. Nulla facilisi. Etiam lacinia neque urna, vel auctor dui tempor at.\n" +
                        "\n" +
                        "Sed sollicitudin enim a nulla convallis auctor. Vivamus condimentum, leo a vestibulum varius, turpis sapien lacinia elit, ut malesuada sapien massa eu dui. Phasellus eget fermentum elit. Curabitur auctor libero ac nulla convallis, ac malesuada dolor feugiat. Pellentesque in scelerisque libero. Curabitur malesuada nisi et hendrerit posuere. Sed eu tortor eget elit vestibulum aliquam non a lectus. Nulla facilisi.\n" +
                        "\n" +
                        "Sed euismod auctor lectus, sit amet bibendum libero. Pellentesque lacinia urna id tortor vehicula, vel gravida risus facilisis. Sed efficitur ligula nec ligula ultricies, nec tristique orci vestibulum. Sed euismod et purus vel fermentum. Fusce eget lorem quis odio interdum facilisis. Integer eget erat libero. Curabitur id lacinia lorem, ut auctor mi. Maecenas eget congue urna. Duis in lectus nec eros bibendum scelerisque. Sed fringilla urna vel erat rhoncus, sit amet elementum elit feugiat.\n" +
                        "\n" +
                        "Duis efficitur, arcu ut euismod ultrices, dui libero scelerisque mi, sit amet pharetra libero elit eget arcu. Sed sit amet erat non libero efficitur facilisis ac a\n",
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
