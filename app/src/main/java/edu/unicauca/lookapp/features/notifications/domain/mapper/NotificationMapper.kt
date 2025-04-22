package edu.unicauca.lookapp.features.notifications.domain.mapper

import edu.unicauca.lookapp.features.notifications.data.entities.NotificationEntity
import edu.unicauca.lookapp.features.notifications.domain.model.Notification

fun NotificationEntity.toDomain(): Notification = Notification(
    id = id,
    title = title,
    message = message,
    timestamp = timestamp,
    isRead = isRead
)

fun Notification.toEntity(): NotificationEntity = NotificationEntity(
    id = id,
    title = title,
    message = message,
    timestamp = timestamp,
    isRead = isRead
)