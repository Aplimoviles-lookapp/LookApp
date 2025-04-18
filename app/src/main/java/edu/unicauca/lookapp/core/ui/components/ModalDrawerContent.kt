package edu.unicauca.lookapp.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.lookapp.R

@Composable
fun ModalDrawerContent(
    modifier: Modifier = Modifier,
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                stringResource(R.string.lookapp),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge
            )
            HorizontalDivider()

            Text(
                "Atajos",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_home)) },
                selected = false,
                onClick = { /* Handle click */ }
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_search)) },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_reservations)) },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_stylist)) },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_discounts)) },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_saved)) },
                selected = false,
                onClick = { /* Handle click */ }
            )

            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_profile)) },
                selected = false,
                onClick = { /* Handle click */ }
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_settings)) },
                selected = false,
                icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                onClick = { /* Handle click */ }
            )
            NavigationDrawerItem(
                label = { Text(stringResource(R.string.lateral_txt_help_and_feedback)) },
                selected = false,
                icon = { Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null) },
                onClick = { /* Handle click */ },
            )
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun ModalDrawerContentPreview() {
    ModalDrawerContent(
    )
}