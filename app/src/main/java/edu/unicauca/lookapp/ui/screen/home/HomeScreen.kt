package edu.unicauca.lookapp.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.ui.components.BottomNavBar
import edu.unicauca.lookapp.ui.components.TopAppBar
import edu.unicauca.lookapp.ui.theme.LookAppTheme

@Composable
fun Home(
    modifier: Modifier=Modifier
){
    Column{
        TopAppBar(title = R.string.title_Home)
        NavigationBarMenuMain()
        Spacer(modifier = Modifier.height(8.dp))
        Form()
    }

}

@Composable
fun HomeScreen(){
    LookAppTheme{
        Scaffold (
           // topBar = { TopAppBar(title = R.string.title_Home)},
            bottomBar = { BottomNavBar() }

        ){ padding ->
            Home(Modifier.padding(padding))

        }
    }

}

@Preview
@Composable
fun HomePreview(){
    Home()
}

@Preview(showBackground = true, locale = "es")
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}