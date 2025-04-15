package edu.unicauca.lookapp.features.saved.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.core.ui.components.BottomNavBar
import edu.unicauca.lookapp.core.ui.components.TopAppBar
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.ui.viewmodel.SavedViewModel
import kotlinx.coroutines.flow.asFlow

@Composable
fun SavedScreen(modifier: Modifier = Modifier, savedViewModel: SavedViewModel = hiltViewModel()) {
    val savedItems = savedViewModel.getSavedItems().collectAsState(
        initial = emptyList()
    )
    LaunchedEffect(Unit) {
        savedViewModel.loadInitialData()
    }
    LazyColumn(modifier = modifier.padding(8.dp)) {
        items(savedItems.value) { item ->
            SavedItem(
                title = item.title,
                subtitle = item.subtitle,
                imageUrl = item.imageUrl,
                onDelete = { /*savedViewModel.deleteItem(item)*/ },
                modifier = Modifier
            )
        }
    }
    /*LazyColumn(modifier = modifier.padding(8.dp)) {

        items(10) {
            SavedItem(
                title = "Caroy Peluqueria",
                subtitle = "Corte de cabello",
                imageUrl = "https://picsum.photos/201",
                onDelete = {},
                modifier = Modifier
            )
        }
    }*/
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