package edu.unicauca.lookapp.ui.screen.userprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.ui.components.BottomNavBar
import edu.unicauca.lookapp.ui.components.TopAppBar
import edu.unicauca.lookapp.ui.screen.saved.SavedScreen

@Composable
fun UserProfileScreen(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
    ) {
        item {
            MyAccountSection(userName = "Pepito Perez")
        }
        item {
            //TODO: Sacar las accounts del viewmodel
            AccountsSection(
                accounts = listOf(
                    UserAccount("Juan", "Juan@gmail.com"),
                    UserAccount("Naren", "Naren@gmail.com"),
                    UserAccount("Ruben","ruben@gmail.com"),
                    UserAccount("Freider","freider@gmail.com")

            )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    Scaffold(
        topBar = { TopAppBar(title = R.string.title_user_data) },
        bottomBar = { BottomNavBar() }
    ) { padding ->
        UserProfileScreen(Modifier.padding(padding))
    }
}