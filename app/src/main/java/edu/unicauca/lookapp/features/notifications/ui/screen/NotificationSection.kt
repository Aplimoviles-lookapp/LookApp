package edu.unicauca.lookapp.features.notifications.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NotificationsSection(title: String, notifications: List<NotificationModel>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(vertical = 8.dp))
        notifications.forEach { notification ->
            NotificationItem(notification)
        }
    }
}