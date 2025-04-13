package edu.unicauca.lookapp.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CollectionsBookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.core.ui.navigation.RouteEnum

data class BottomNavItem(val route: String, val icon: ImageVector, val label: Int)

@Composable
fun BottomNavBar(modifier: Modifier= Modifier, currentRoute: String = RouteEnum.Home.route, onNavigate: (String) -> Unit = {}) {
    val items = listOf(
        BottomNavItem(RouteEnum.Home.route, Icons.Filled.Home, R.string.nvb_home),
        BottomNavItem(RouteEnum.Search.route, Icons.Filled.Search, R.string.nvb_search),
        BottomNavItem(RouteEnum.Saved.route, Icons.Filled.CollectionsBookmark, R.string.nvb_saved),
        BottomNavItem(RouteEnum.Notifications.route, Icons.Filled.Notifications, R.string.nvb_notifications)
    )

    NavigationBar (
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        modifier = modifier
    ){
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(stringResource(item.label)) },
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) },

            )
        }

    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun BottomNavBarPreview() {
    BottomNavBar()
}
