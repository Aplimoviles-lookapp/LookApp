package edu.unicauca.lookapp.features.notifications.ui.screen

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import edu.unicauca.lookapp.R

@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    val recentNotifications = listOf(
        NotificationModel("A", "Tu reserva ha sido exitosa", "Su reserva ha sido designada para el día 12/02/2025 a las 11:40 AM."),
        NotificationModel("T", "¡Se ha liberado un turno!", "Un turno ha quedado disponible en Vanity para HOY a las 3:00 PM. ¡Reserva antes de que se ocupe!"),
        NotificationModel("T", "¡Se ha liberado un turno!", "Un turno ha quedado disponible en Vanity para HOY a las 3:00 PM. ¡Reserva antes de que se ocupe!"),
        NotificationModel("T", "¡Se ha liberado un turno!", "Un turno ha quedado disponible en Vanity para HOY a las 3:00 PM. ¡Reserva antes de que se ocupe!"),
        NotificationModel("T", "¡Se ha liberado un turno!", "Un turno ha quedado disponible en Vanity para HOY a las 3:00 PM. ¡Reserva antes de que se ocupe!"),
        NotificationModel("T", "¡Se ha liberado un turno!", "Un turno ha quedado disponible en Vanity para HOY a las 3:00 PM. ¡Reserva antes de que se ocupe!")
    )

    val pastNotifications = listOf(
        NotificationModel("B", "¡Descuento exclusivo para ti!", "Solo por hoy, 30% de descuento en cortes y peinados en Barber Shop. ¡Reserva tu turno!"),
        NotificationModel("L", "¡Nuevo combo de belleza!", "Manicure + Pedicure + Peinado por solo 40.000 en Lilis. ¡Aprovecha esta oferta limitada!")
    )

    val context = LocalContext.current
    val channelID = "chat"
    val channelName = "Chat Notifications"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelID, channelName, importance)
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (!isGranted) {
            // Mostrar un mensaje
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
    ) {
        NotificationsSection(title = "HOY", notifications = recentNotifications)
        NotificationsSection(title = "AYER", notifications = pastNotifications)
        Button(onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (context.checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) !=
                    android.content.pm.PackageManager.PERMISSION_GRANTED
                ) {
                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    return@Button
                }
            }

            val notification = NotificationCompat.Builder(context, channelID)
                .setContentTitle("Título")
                .setContentText("Esto es un texto")
                .setSmallIcon(R.drawable.ic_notification)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()

            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(1, notification)

        }) {
            Text("Enviar Notificación")
        }
    }
}