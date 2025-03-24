package edu.unicauca.lookapp.ui.screen.saved

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.ui.components.BottomNavBar
import edu.unicauca.lookapp.ui.components.TopAppBar

@Composable
fun SavedScreen(modifier: Modifier = Modifier) {
    LazyColumn {
        items(10) {
            SavedItem(
                title = "Caroy Peluqueria",
                subtitle = "Corte de cabello",
                imageUrl = "https://picsum.photos/200",
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
        topBar = { TopAppBar(title = R.string.title_saved) },
        bottomBar = { BottomNavBar()}
    ) { padding ->
        SavedScreen(Modifier.padding(padding))
    }
}