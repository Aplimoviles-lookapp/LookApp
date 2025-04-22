package edu.unicauca.lookapp.ui.screen.home



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NavigationBarMenuMain(
    modifier: Modifier=Modifier
){

    NavigationBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
        
    ) {

        NavigationBarItem(
            icon = {},
            label = {

                Text(
                    text = "Agendar"
                )
            },
            selected = true,
            onClick = {}
        )

        NavigationBarItem(
            icon = {},
            label = {
                Text(
                    text = "Cola"
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {},
            label = {
                Text(
                    text = "Productos"
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {},
            label = {
                Text(
                    text = "Sitios"
                )
            },
            selected = false,
            onClick = {}
        )



    }

}

@Composable
fun TabBar(
    modifier: Modifier=Modifier
){
    val tabs = listOf("Agendar", "Cola", "Productos", "Sitios")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier

                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .padding(horizontal = 16.dp)
                        .height(3.dp)
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)), // Redondeado
                   color = MaterialTheme.colorScheme.primary
                )
            },
            divider = {}
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor =  MaterialTheme.colorScheme.onSurfaceVariant,
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }


    }
}
@Preview
@Composable
fun NavigationBarMenuMainPreview(){
    NavigationBarMenuMain()
}
@Preview
@Composable
fun TabBarPreview(){
    TabBar()
}
