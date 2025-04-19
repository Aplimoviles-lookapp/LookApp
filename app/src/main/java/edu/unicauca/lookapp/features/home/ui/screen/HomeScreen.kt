package edu.unicauca.lookapp.features.home.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.core.ui.components.BottomNavBar
import edu.unicauca.lookapp.core.ui.components.TopAppBar
import edu.unicauca.lookapp.ui.screen.home.TabBar
import java.util.Date



@Composable
fun Home(
    modifier: Modifier=Modifier
){
    Column{

        TabBar()
        Spacer(modifier = Modifier.height(8.dp))
        Form()
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
    Scaffold (

        topBar = { TopAppBar(title = R.string.title_Home)},
        bottomBar = { BottomNavBar() }

    ){ padding ->
        Home(Modifier.padding(padding))

    }
}