package com.droidsmith.mcunexus.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.droidsmith.mcunexus.ui.theme.TextWhite
import com.droidsmith.mcunexus.ui.theme.marvel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(
    viewModel: ViewModel,
    title: String,
    placeholderText: String,
    fontFamily: FontFamily? = marvel,
    onSearch: (query: String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            fontFamily = fontFamily,
            color = TextWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = text,
                shape = ShapeDefaults.Small,
                onQueryChange = { text = it },
                onSearch = {
                    active = false
                    onSearch(text)
                },
                active = active,
                onActiveChange = { active = it },
                placeholder = { Text(text = placeholderText) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
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
}