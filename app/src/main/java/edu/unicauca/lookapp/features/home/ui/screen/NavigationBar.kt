package edu.unicauca.lookapp.features.home.ui.screen


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


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