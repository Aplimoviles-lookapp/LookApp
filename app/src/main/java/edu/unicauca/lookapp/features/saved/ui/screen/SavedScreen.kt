package edu.unicauca.lookapp.features.saved.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.core.ui.components.BottomNavBar
import edu.unicauca.lookapp.core.ui.components.TopAppBar

@Composable
fun SavedScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(8.dp)) {
        items(10) {
            SavedItem(
                title = "Caroy Peluqueria",
                subtitle = "Corte de cabello",
                imageUrl = "https://picsum.photos/201",
                onDelete = {},
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun SavedScreenPreview() {
    Scaffold(
        topBar = { TopAppBar(title = R.string.title_saved,) },
        bottomBar = { BottomNavBar() }
    ) { padding ->
        SavedScreen(Modifier.padding(padding))
    }
}