package edu.unicauca.lookapp.ui.screen.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NavigationBarMenuMain(
    modifier: Modifier=Modifier
){

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = modifier
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
@Preview
@Composable
fun NavigationBarMenuMainPreview(){
    NavigationBarMenuMain()
}