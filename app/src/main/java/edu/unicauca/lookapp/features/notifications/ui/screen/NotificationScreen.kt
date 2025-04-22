package edu.unicauca.lookapp.features.notifications.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.unicauca.lookapp.features.notifications.domain.model.Notification
import edu.unicauca.lookapp.features.notifications.ui.viewmodel.NotificationsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    viewModel: NotificationsViewModel = hiltViewModel()
) {
    val notifications by viewModel.notifications.collectAsState()

    Scaffold(
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.End
            ) {
                FloatingActionButton(
                    onClick = { viewModel.deleteAll() },
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Borrar todo")
                }

                FloatingActionButton(
                    onClick = { viewModel.createFakeNotifications() },
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Agregar")
                }
            }
        }
    ) { padding ->
        if (notifications.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No tienes notificaciones.")
            }
        } else {
            val grouped = groupNotificationsByDay(notifications)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                grouped.forEach { (title, list) ->
                    item {
                        NotificationsSection(title = title, notifications = list) { notif ->
                            if (!notif.isRead) {
                                viewModel.markAsRead(notif.id)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun groupNotificationsByDay(notifications: List<Notification>): Map<String, List<Notification>> {
    val now = System.currentTimeMillis()
    val oneDayMillis = 24 * 60 * 60 * 1000

    val recent = mutableListOf<Notification>()
    val older = mutableListOf<Notification>()

    for (notification in notifications) {
        if (now - notification.timestamp < oneDayMillis) {
            recent.add(notification)
        } else {
            older.add(notification)
        }
    }

    val grouped = mutableMapOf<String, List<Notification>>()
    if (recent.isNotEmpty()) grouped["Recientes"] = recent
    if (older.isNotEmpty()) grouped["Antiguas"] = older

    return grouped
}