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
import edu.unicauca.lookapp.core.ui.viewmodel.MainViewModel
import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.saved.ui.viewmodel.SavedViewModel
import edu.unicauca.lookapp.features.userprofile.ui.viewmodel.UserProfileViewModel
import kotlinx.coroutines.flow.asFlow

@Composable
fun SavedScreen(
    modifier: Modifier = Modifier,
    savedViewModel: SavedViewModel = hiltViewModel(),
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val currentUser = mainViewModel.uiState.collectAsState().value.currentUserAccount
    val savedItems = currentUser?.let {
        savedViewModel.getSavedItems(it.id).collectAsState(
            initial = emptyList()
        )
    }


    LazyColumn(modifier = modifier.padding(8.dp)) {
        if (savedItems != null) {
            items(savedItems.value) { item ->
                SavedItem(
                    title = item.title,
                    subtitle = item.subtitle,
                    imageUrl = item.imageUrl,
                    onDelete = { savedViewModel.deleteItem(item.itemId) },
                    modifier = Modifier
                )
            }
        }
    }

}

@Preview(showBackground = true, locale = "es")
@Composable
fun SavedScreenPreview() {
    Scaffold(
        topBar = { TopAppBar(title = R.string.title_saved) },
        bottomBar = { BottomNavBar() }
    ) { padding ->
        SavedScreen(Modifier.padding(padding))
    }
}